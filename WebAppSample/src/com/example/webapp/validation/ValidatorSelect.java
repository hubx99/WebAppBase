package com.example.webapp.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorSelect extends ValidatorBase<String> {
	@Override
	public String validate(Item v, HttpServletRequest req) {
		String s = req.getParameter("f" + v.getId());

		int i = s.length();

		// if (v.getValidMin() != null && i < v.getValidMin()) {
		// System.out.println("min err");
		// }
		// if (v.getValidMax() != null && i > v.getValidMax()) {
		// System.out.println("max err");
		// }
		//
		// if (v.getRequired() != null && v.getRequired() != 0) {
		// if (s == null || s.length() == 0) {
		// System.out.println("required!!");
		// }
		// }

		return s;
	}

	@Override
	public String writeOut(Item v, Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();

		sb.append("<select");
		sb.append(" id=\"f").append(v.getId()).append("\"");
		sb.append(" name=\"f").append(v.getId()).append("\">");

		sb.append("<option>").append("a").append("</option>");
		sb.append("<option>").append("b").append("</option>");
		sb.append("<option>").append("c").append("</option>");

		sb.append("</select>");
		//
		// sb.append("<div");
		// sb.append(" class=\"message\"");
		// sb.append(">").append("</div>");

		return sb.toString();
	}
}
