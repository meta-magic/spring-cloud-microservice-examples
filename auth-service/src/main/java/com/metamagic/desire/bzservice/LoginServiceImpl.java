package com.metamagic.desire.bzservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.metamagic.desire.dto.LoginBean;
import com.metamagic.desire.dto.LoginResponseBean;

@Service
public class LoginServiceImpl implements LoginService
{

	@Override
	public LoginResponseBean authenticate(LoginBean loginBean) {
		LoginResponseBean loginResponse = new LoginResponseBean(false,null);
		
		if((loginBean !=null && (loginBean.getLoginId().equals(loginBean.getPassword())))){
			loginResponse.setStatus(true);
			loginResponse.setTokenId(UUID.randomUUID().toString());
			// Once authenticate, raise the token creation service which returns token Id. Use token generated instead of UUID string.
		}
		return loginResponse;
	}
}
