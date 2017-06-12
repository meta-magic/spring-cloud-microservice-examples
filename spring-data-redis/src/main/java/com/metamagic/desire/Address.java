package com.metamagic.desire;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

public class Address implements Serializable 
{
	
	@Indexed
	private String country;
	
	
	private String addressLine;
	
	public Address(){
		
	}
	
	public Address(String country, String addressLine){
		this.country  = country;
		this.addressLine = addressLine; 
	}



	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	@Override
	public String toString() {
		return "Address [ country=" + country + ", addressLine=" + addressLine + "]";
	}
	
	
		
	
}
