package com.example.webapp.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.webapp.Constants;
import com.example.webapp.bean.User;
import com.example.webapp.web.AddModel;
import com.example.webapp.web.BaseServlet;
import com.example.webapp.web.EditModel;
import com.example.webapp.web.ListModel;

@WebServlet("/users/*")
public class GServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Class<? extends ListModel> listModel;
	private Class<? extends AddModel> addModel;
	private Class<? extends EditModel> editModel;

	public GServlet() {
		listModel = UsersListModel.class;
		addModel = UserAddModel.class;
		editModel = UserModel.class;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = path2(req);
		if ("".equals(path)) {
			ListModel model = buildModel(listModel);
			model.setUser((User) req.getSession().getAttribute(Constants.SESSION_AUTH));
			model.open();
			req.setAttribute("m", model);
			forward(req, res, "list.jsp");
		} else if ("/new".equals(path)) {
			AddModel model = buildModel(addModel);
			model.setUser((User) req.getSession().getAttribute(Constants.SESSION_AUTH));
			model.open();
			req.setAttribute("m", model);
			forward(req, res, "edit.jsp");
		} else {
			redirect(req, res, req.getServletPath());
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = path2(req);
		AddModel model;
		if ("/new".equals(path)) {
			model = buildModel(addModel);
		} else if ("/edit".equals(path)) {
			model = buildModel(editModel);
		} else {
			redirect(req, res, req.getServletPath());
			return;
		}

		model.setUser((User) req.getSession().getAttribute(Constants.SESSION_AUTH));
		model.setId(req.getParameter("id"));
		if ("submit".equals(req.getParameter("action"))) {
			model.setReq(req);
			model.submit();
			if (model.isSuccess()) {
				redirect(req, res, req.getServletPath());
				return;
			}
		} else {
			model.open();
		}
		req.setAttribute("m", model);
		forward(req, res, "edit.jsp");
	}

	private <R> R buildModel(Class<R> cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
