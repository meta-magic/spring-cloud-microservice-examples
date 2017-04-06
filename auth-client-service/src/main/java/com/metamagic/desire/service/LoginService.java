package com.metamagic.desire.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metamagic.desire.utils.ResponseBean;

public interface LoginService {

	@RequestMapping(value="/auth/login/authenticate", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> authenticate(@RequestBody Object loginBean);
}
