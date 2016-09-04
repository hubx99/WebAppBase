package com.example.webapp.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.bean.Item;

public class ValidatorDate extends ValidatorBase<Date> {
	@Override
	public Date validate(Item v, HttpServletRequest req) {
		String s = req.getParameter("f" + v.getId());
		if (s == null)
			return null;

		SimpleDateFormat dform = new SimpleDateFormat("yyyy-MM-dd");
		dform.setLenient(false);
		try {
			return dform.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	// @Override
	// public String writeOut(ViewItem v) {
	// StringBuilder sb = new StringBuilder();
	//
	// sb.append("<div><input type=\"date\"");
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

	@Override
	public String getStringValue(Item v, Map<String, Object> map) {
		// if (v.getValue() == null) {
		// return "";
		// }
		// return new SimpleDateFormat("yyyy/MM/dd").format((Date)
		// v.getValue());
		return "";
	}
}
