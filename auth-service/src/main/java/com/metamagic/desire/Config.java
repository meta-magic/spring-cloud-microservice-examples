package com.metamagic.desire;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@RefreshScope
@Configuration
@EnableEurekaClient
@EnableAspectJAutoProxy
@ComponentScan
public class Config {

}
