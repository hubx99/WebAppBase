package com.example.webapp.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public interface Validator<R> {
	public R validate(Item v, HttpServletRequest req);

	public String writeOut(Item v, Map<String, Object> map);

	public String getStringValue(Item v, Map<String, Object> map);
}
