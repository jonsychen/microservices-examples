package com.mtp.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
public interface MQService {
	
	String INPUT_CHANNEL = "input";
	String OUTPUT_CHANNEL = "output";
	
    @Input(MQService.INPUT_CHANNEL)
    SubscribableChannel receiver();
    
    @Output(MQService.OUTPUT_CHANNEL)
    MessageChannel sender();

}
