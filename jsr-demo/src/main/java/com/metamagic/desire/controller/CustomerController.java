package com.metamagic.desire.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.desire.bean.Customer;
import com.metamagic.desire.utils.ResponseBean;

@RestController
public class CustomerController {

	@RequestMapping(value = "/cust", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> authenticate(HttpServletRequest request, @RequestBody Customer customer) {
		System.err.println(this.getClass() + " " + customer);
		ResponseBean responseBean = new ResponseBean("Returning same customer data", "Success", true, customer);
		return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
	}
}
