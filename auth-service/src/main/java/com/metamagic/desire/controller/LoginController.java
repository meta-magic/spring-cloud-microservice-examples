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

import com.metamagic.desire.bzservice.LoginService;
import com.metamagic.desire.dto.LoginBean;
import com.metamagic.desire.dto.LoginResponseBean;
import com.metamagic.desire.utils.ResponseBean;

@RestController
@RequestMapping("/auth/login/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> authenticate(HttpServletRequest request, @RequestBody LoginBean loginBean){
		System.err.println(this.getClass() +" "+loginBean);
		LoginResponseBean bean = loginService.authenticate(loginBean);
		if(bean.isStatus()){
			ResponseBean responseBean = new ResponseBean("User authenticated", "40404041", true, bean);
			return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
		}else{
			ResponseBean responseBean = new ResponseBean("Invalid userid or password", "Error-40404041", true, bean);
			return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
		}
	}
}
