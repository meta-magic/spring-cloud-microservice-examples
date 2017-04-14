package com.metamagic.desire.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.metamagic.desire.utils.CommonValidator;

public class Customer implements CommonValidator {

	@NotNull(message = "First name should not be null")
	@Size(min=2, max=200, message="First name size is min =2 and max =200")
	private String fName;

	private String mName;

	@NotNull(message = "Last name should not be null")
	@Size(min=2, max=200, message="Last name size is min =2 and max =200")
	private String lName;

	@NotNull(message = "Email id should not be null")
	private String email;

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
