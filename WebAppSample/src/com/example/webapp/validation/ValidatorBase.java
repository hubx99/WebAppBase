package com.example.webapp.validation;

import java.util.Map;
import java.util.Objects;

import com.example.webapp.bean.Item;
import com.example.webapp.bean.Item.VarType;

public abstract class ValidatorBase<R> implements Validator<R> {

	@Override
	public String getStringValue(Item v, Map<String, Object> map) {
		return Objects.toString(map.get(v.getKey()), "");
	}

	@Override
	public String writeOut(Item v, Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"").append(toTypeHtml(v.getVarType())).append("\"");
		sb.append(" id=\"id_").append(v.getId()).append("\"");
		sb.append(" name=\"").append(v.getId()).append("\"");
		sb.append(" value=\"").append(getStringValue(v, map)).append("\"");
		sb.append(" />");
		return sb.toString();
	}

	private String toTypeHtml(VarType type) {
		if (type == VarType.VIEW) {
			return "hidden";
		} else {
			return type.toString();
		}
	}
}
