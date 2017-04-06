package com.metamagic.desire;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableZuulProxy
public class Config {

	@Bean
	public LogFilter logFilter(){
		return new LogFilter();
	}
}
