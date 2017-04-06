package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(value=SourceChannel.class)
public class HelloWorldController {

	@Autowired
	@Output(SourceChannel.OUTPUT)
	MessageChannel output;
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public void hello(@RequestBody String name){
		System.out.println("Name : "+name);
		output.send(MessageBuilder.withPayload("Hello : "+name).build());
	}
}
