package com.example.webapp.web;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.User;

public abstract class BaseModel {
	public static enum Code {
		SUCCESS, //
		ERR_OTHER
	};

	private Code code = Code.ERR_OTHER;
	private User user;
	private HttpServletRequest req;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public void setSuccess() {
		this.code = Code.SUCCESS;
	}

	public boolean isSuccess() {
		return this.code == Code.SUCCESS;
	}
}
