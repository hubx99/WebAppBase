package com.example.webapp.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.webapp.Constants;
import com.example.webapp.bean.User;
import com.example.webapp.web.BaseServlet;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute(Constants.SESSION_AUTH) != null) {
			res.sendRedirect(req.getContextPath() + "/main");
			return;
		}
		if (session != null) {
			req.setAttribute("message", session.getAttribute("message"));
			session.removeAttribute("message");
		}

		LoginModel model = new LoginModel();

		req.setAttribute("m", model);
		forward(req, res, "login.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User user = new User();
		user.setTenantId(req.getParameter("tenant"));
		user.setId(req.getParameter("id"));
		user.setPassword(req.getParameter("password"));

		LoginModel model = new LoginModel();
		model.setUser(user);
		model.authenticate();

		if (model.isAuthenticated()) {
			HttpSession session = req.getSession();
			if (!session.isNew()) {
				req.changeSessionId();
			}
			session.setAttribute(Constants.SESSION_AUTH, model.getUser());
			res.sendRedirect(req.getContextPath() + "/main");
			return;
		}

		req.getSession().setAttribute("message", "login error");
		res.sendRedirect("login");
	}
}
