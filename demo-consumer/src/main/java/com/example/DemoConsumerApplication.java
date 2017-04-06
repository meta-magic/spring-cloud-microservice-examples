package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

@SpringBootApplication
@EnableBinding(SinkChannel.class)
public class DemoConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConsumerApplication.class, args);
	}
	
	@ServiceActivator(inputChannel=SinkChannel.INPUT)
	public void log(String msg){
		System.out.println("Consumer 1 : "+msg);
	}
}
