package com.example.webapp.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorView extends ValidatorBase<String> {
	@Override
	public String writeOut(Item v, Map<String, Object> map) {
		return getStringValue(v, map) + super.writeOut(v, map);
	}

	@Override
	public String validate(Item v, HttpServletRequest req) {
		return req.getParameter(v.getId());
	}
}
