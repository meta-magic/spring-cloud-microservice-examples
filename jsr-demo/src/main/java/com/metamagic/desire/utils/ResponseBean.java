package com.metamagic.desire.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseBean implements Serializable{

	private String message;
	
	private String messageId;
	
	private boolean success;
	
	private List<String> errors;
	
	private Object response;

	public ResponseBean(String message, String messageId, boolean success, Object response) {
		super();
		this.message = message;
		this.messageId = messageId;
		this.success = success;
		this.response = response;
	}
	
	public ResponseBean(String message, String messageId, boolean success, Object response, List<String> errors) {
		super();
		this.message = message;
		this.messageId = messageId;
		this.success = success;
		this.response = response;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageId() {
		return messageId;
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getResponse() {
		return response;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void addError(String error){
		if(errors == null)
			errors = new ArrayList<String>();
		
		errors.add(error);
	}
	
	
	
}
