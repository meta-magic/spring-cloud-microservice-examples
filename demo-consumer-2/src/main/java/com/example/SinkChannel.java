package com.example;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkChannel {

	String INPUT = "demochannel";
	
	@Input(SinkChannel.INPUT)
	SubscribableChannel input();
}
