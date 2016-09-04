package com.example.webapp.web.login;

import org.apache.ibatis.session.SqlSession;

import com.example.webapp.bean.User;
import com.example.webapp.db.DBMapper;
import com.example.webapp.db.DBUtil;

public class LoginModel {
	private boolean multiTenant;
	private User user;
	private boolean authenticated;

	public LoginModel() {
		multiTenant = true;
	}

	public void authenticate() {
		if (!multiTenant) {
			user.setTenantId("1");
		}

		System.out.println(user.getTenantId());
		System.out.println(user.getId());
		System.out.println(user.getPassword());

		try (SqlSession session = DBUtil.openSession()) {
			DBMapper db = session.getMapper(DBMapper.class);
			User dbUser = db.selectUser(user);
			if (dbUser != null) {
				user = dbUser;
				authenticated = true;
			}
		}
	}

	public boolean isMultiTenant() {
		return multiTenant;
	}

	public void setMultiTenant(boolean multiTenant) {
		this.multiTenant = multiTenant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
