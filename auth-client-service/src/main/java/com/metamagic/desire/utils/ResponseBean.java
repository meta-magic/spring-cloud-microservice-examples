package com.metamagic.desire.utils;

public class ResponseBean{

	private String message;
	
	private String messageId;
	
	private boolean success;
	
	private Object response;

	public ResponseBean(){
		
	}
	
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

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setResponse(Object response) {
		this.response = response;
	}


	
	
	
}
