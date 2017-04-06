package com.example;

import java.util.Date;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(value=SourceChannel.class)
public class MessageProducer {

	//@InboundChannelAdapter(value=SourceChannel.OUTPUT)
	public String helloMessage(){
		return "Hello world "+new Date();
	}

}
