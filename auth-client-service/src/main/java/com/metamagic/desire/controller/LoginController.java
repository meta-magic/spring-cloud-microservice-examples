package com.metamagic.desire.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.desire.client.LoginClient;
import com.metamagic.desire.utils.ResponseBean;

@RestController
@RequestMapping("/auth/login/")
public class LoginController {

	@Autowired
	private LoginClient loginClient;
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> authenticate(HttpServletRequest request, @RequestBody Object loginBean){
		System.out.println("Login bean "+loginBean);
		return loginClient.authenticate(loginBean);
	}
}
