package com.example.webapp.validation;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorText extends ValidatorBase<String> {
	@Override
	public String validate(Item v, HttpServletRequest req) {
		String s = req.getParameter(v.getId());

		s = (s == null) ? "" : s.trim();
		int len = s.length();

		if (v.getValidation().getRequired()) {
			if (len == 0) {
				v.getValidation().setError(true);
			}
		}

		// int i = s.length();
		//
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
}
