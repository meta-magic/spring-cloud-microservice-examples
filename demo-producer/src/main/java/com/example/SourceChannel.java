package com.example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceChannel {

	String OUTPUT = "demochannel";
	
	@Output(SourceChannel.OUTPUT)
	MessageChannel output();
}
