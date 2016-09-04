package com.example.webapp.validation;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorNumber extends ValidatorBase<Integer> {

	@Override
	public Integer validate(Item v, HttpServletRequest req) {
		try {
			String s = req.getParameter("f" + v.getId());

			Integer i = Integer.valueOf(s);

//			if (v.getValidMin() != null && i < v.getValidMin()) {
//				System.out.println("min err");
//			}
//			if (v.getValidMax() != null && i > v.getValidMax()) {
//				System.out.println("max err");
//			}

			return i;
		} catch (Exception e) {
			//
		}
		return null;
	}

	// @Override
	// public String writeOut(ViewItem v) {
	// StringBuilder sb = new StringBuilder();
	//
	// sb.append("<div><input type=\"number\"");
	// sb.append(" id=\"f").append(v.getId()).append("\"");
	// sb.append(" name=\"f").append(v.getId()).append("\"");
	// sb.append(" value=\"").append(getSValue(v)).append("\"");
	// sb.append(" /></div>");
	//
	// sb.append("<div");
	// sb.append(" class=\"message\"");
	// sb.append(">").append("</div>");
	//
	// return sb.toString();
	// }
}
