package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SayHiService;

@RestController
public class SayHiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SayHiController.class);
	@Autowired
	SayHiService sayHiService;
	@Value("${author.name}")  
	String name;
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHi(@RequestParam String name){
		LOGGER.info("beggin say hi to service2 ... ");
		return sayHiService.sayHiToService2(name);		
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String author(){
		LOGGER.info("author name : "+name);
		return name;		
	}
	
	
	
	
	

}
