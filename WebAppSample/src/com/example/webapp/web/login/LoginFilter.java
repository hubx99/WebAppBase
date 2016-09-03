package com.example.webapp.web.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sreq;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("access: " + path);

		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("auth") == null) {
			if ("/login".equals(path) || "/nologin".equals(path) || "/".equals(path)) {
				//
			} else if (path.startsWith("/css/")) {
				// resource
			} else {
				((HttpServletResponse) sres).sendRedirect(req.getContextPath() + "/nologin");
				return;
			}
		}
		chain.doFilter(sreq, sres);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}
}
