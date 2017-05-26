package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MQService;

@RestController
public class MQEventHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQEventHandler.class);
	
	@Autowired
	MQService mqService;
	
	@RequestMapping(value = "/send" ,method = RequestMethod.GET)
    public String sender(@RequestParam("name") String name) {
    	LOGGER.info("...................................................");
    	boolean result =   mqService.sender().send(MessageBuilder.withPayload(name).build());
    	if(result){
    		LOGGER.info("send to rabbit succcess...");
    	}else{
    		LOGGER.info("send to rabbit faild...");
    	}
        return "message has been sent successfully";
    } 
	
	
	@StreamListener(MQService.INPUT_CHANNEL)
    public void receiver(@RequestParam("name") String name) {
    	LOGGER.info("...................................................");
    	LOGGER.info("receive message from rabbit :"+name);
    }
	
	
	
	
	
	
	

}
