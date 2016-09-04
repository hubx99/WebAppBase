package com.example.webapp.validation;

public class Validation {
	private String varType;
	private Boolean required;
	private Integer validMin;
	private Integer validMax;
	private String pattern;
	private String message;

	private boolean error = false;

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public Integer getValidMin() {
		return validMin;
	}

	public void setValidMin(Integer validMin) {
		this.validMin = validMin;
	}

	public Integer getValidMax() {
		return validMax;
	}

	public void setValidMax(Integer validMax) {
		this.validMax = validMax;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
