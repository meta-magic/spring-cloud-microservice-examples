package com.metamagic.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;

public class FooConfiguration {

	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
	
	
}
