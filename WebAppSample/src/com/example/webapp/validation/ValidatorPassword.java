package com.example.webapp.validation;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorPassword extends ValidatorBase<String> {
	@Override
	public String validate(Item v, HttpServletRequest req) {

		String s = req.getParameter("f" + v.getId());
		String s2 = req.getParameter("f" + v.getId() + "_cfm");

		if (!Objects.equals(s, s2)) {
			System.out.println("unmatch");
			return null;
		}

		int i = s.length();

		// if (v.getValidMin() != null && i < v.getValidMin()) {
		// System.out.println("min err");
		// }
		// if (v.getValidMax() != null && i > v.getValidMax()) {
		// System.out.println("max err");
		// }

		return s;
	}

	@Override
	public String writeOut(Item v, Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();

		sb.append("<div><input type=\"password\"");
		sb.append(" id=\"f").append(v.getId()).append("\"");
		sb.append(" name=\"f").append(v.getId()).append("\"");
		sb.append(" /></div>");

		sb.append("<div><input type=\"password\"");
		sb.append(" id=\"f").append(v.getId()).append("_cfm\"");
		sb.append(" name=\"f").append(v.getId()).append("_cfm\"");
		sb.append(" /></div>");

		// sb.append("<div");
		// sb.append(" class=\"message\"");
		// sb.append(">").append("</div>");

		return sb.toString();
	}

	@Override
	public String getStringValue(Item v, Map<String, Object> map) {
		return "";
	}
}
