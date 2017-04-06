package com.metamagic.desire.dto;

public class LoginResponseBean {

	private boolean status;
	
	private String tokenId;
	
	public LoginResponseBean(){
	}

	public LoginResponseBean(boolean status, String tokenId) {
		super();
		this.status = status;
		this.tokenId = tokenId;
	}



	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Override
	public String toString() {
		return "LoginResponseBean [status=" + status + ", tokenId=" + tokenId + "]";
	}
	
	
	
}
