package com.example.webapp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	protected void forward(HttpServletRequest req, HttpServletResponse res, String jsp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/" + jsp).forward(req, res);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse res, String path) throws IOException {
		res.sendRedirect(req.getContextPath() + path);
	}

	protected String path(HttpServletRequest req) {
		return req.getRequestURI().substring(req.getContextPath().length());
	}

	protected String path2(HttpServletRequest req) {
		return req.getRequestURI().substring(req.getContextPath().length() + req.getServletPath().length());
	}
}
