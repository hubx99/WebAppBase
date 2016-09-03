package com.example.webapp.web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("auth") != null) {
			res.sendRedirect(req.getContextPath() + "/main");
			return;
		}
		if (session != null) {
			req.setAttribute("message", session.getAttribute("message"));
			session.removeAttribute("message");
		}

		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO authentication
		if ("a".equals(req.getParameter("id"))) {
			if ("b".equals(req.getParameter("password"))) {
				HttpSession session = req.getSession();
				if (!session.isNew()) {
					req.changeSessionId();
				}
				session.setAttribute("auth", "");

				res.sendRedirect(req.getContextPath() + "/main");
				return;
			}
		}

		req.getSession().setAttribute("message", "login error");
		res.sendRedirect("login");
	}
}
