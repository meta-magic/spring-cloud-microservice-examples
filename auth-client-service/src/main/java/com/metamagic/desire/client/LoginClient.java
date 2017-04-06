package com.metamagic.desire.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.metamagic.config.FooConfiguration;
import com.metamagic.desire.fallback.LoginFallBack;
import com.metamagic.desire.service.LoginService;

@FeignClient(value="authservice",configuration=FooConfiguration.class, fallback=LoginFallBack.class)
public interface LoginClient extends LoginService{

}
