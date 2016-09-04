package com.example.webapp.bean;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.webapp.validation.Validation;
import com.example.webapp.validation.Validator;
import com.example.webapp.validation.ValidatorText;
import com.example.webapp.validation.ValidatorView;

public class Item {
	private String key;
	private String label;
	private VarType varType;

	private Validation validation;
	Validator<?> validator;

	public static enum VarType {
		TEXT, VIEW;

		@Override
		public String toString() {
			return name().toLowerCase(Locale.ENGLISH).toString();
		}
	};

	public Item() {
		setVarType(VarType.TEXT);
		validation = new Validation();
		validation.setRequired(true);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return this.key;
	}

	public String writeOut(Map<String, Object> map) {
		String s = validator.writeOut(this, map);
		System.out.println("writeOut: " + getKey());
		return s;
	}

	public Object validate(HttpServletRequest req) {
		return validator.validate(this, req);
	}

	public VarType getVarType() {
		return varType;
	}

	public void setVarType(VarType varType) {
		this.varType = varType;

		switch (varType) {
		case VIEW:
			validator = new ValidatorView();
			break;
		case TEXT:
			validator = new ValidatorText();
			break;
		default:
			validator = new ValidatorText();
			break;
		}
	}

	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}
}
