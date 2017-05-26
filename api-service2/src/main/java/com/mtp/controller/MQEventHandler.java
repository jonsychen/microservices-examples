package com.mtp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtp.service.MQService;

@RestController
public class MQEventHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQEventHandler.class);
	
	@Autowired
	MQService mqService;
	
	
	@StreamListener(MQService.INPUT_CHANNEL)
	@SendTo(MQService.OUTPUT_CHANNEL)
    public String receiver(@RequestParam("name") String name) {
    	LOGGER.info("...................................................");
    	LOGGER.info("receive message from rabbit :"+name);
    	return name;
    }
	

}
