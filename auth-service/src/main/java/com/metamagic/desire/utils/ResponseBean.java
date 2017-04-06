package com.metamagic.desire.utils;

import java.io.Serializable;

public class ResponseBean implements Serializable{

	private String message;
	
	private String messageId;
	
	private boolean success;
	
	private Object response;

	public ResponseBean(String message, String messageId, boolean success, Object response) {
		super();
		this.message = message;
		this.messageId = messageId;
		this.success = success;
		this.response = response;
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

	
	
	
}
