package com.metamagic.desire.bzservice;

import com.metamagic.desire.dto.LoginBean;
import com.metamagic.desire.dto.LoginResponseBean;

public interface LoginService {

	public LoginResponseBean authenticate(LoginBean loginBean);
}
