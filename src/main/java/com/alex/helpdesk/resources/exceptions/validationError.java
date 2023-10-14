package com.alex.helpdesk.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class validationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<fildMessage> errors = new ArrayList<>();

	public validationError() {
		super();
	}

	public validationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<fildMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fildName, String message) {
		this.errors.add(new fildMessage(fildName, message));
	}
	
}
