package com.metamagic.desire.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.metamagic.desire.client.LoginClient;
import com.metamagic.desire.utils.ResponseBean;

@Service
public class LoginFallBack implements LoginClient{

	@Override
	public ResponseEntity<ResponseBean> authenticate(Object loginBean) {
		ResponseBean bean = new ResponseBean("login service is unavailable, please try after some time ", "303030", false, null);
		return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
	}

}
