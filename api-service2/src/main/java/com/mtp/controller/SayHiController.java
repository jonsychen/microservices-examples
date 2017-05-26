package com.mtp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SayHiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SayHiController.class);

	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHi(@RequestParam String name){
		LOGGER.info("...................................");
		LOGGER.info("get hi from :"+name);
		return "hi from service2";
	}
	
	
	@RequestMapping(value = "/hi2", method = RequestMethod.GET)
	public String sayHi2(@RequestParam String name){
		LOGGER.info("...................................");
		LOGGER.info("get hi from :"+name);
		return "hi from service2";
	}
	
	
	
	
	

}
