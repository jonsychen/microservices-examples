package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Jonsy
 *
 */
@RestController
@RefreshScope
public class SayHiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SayHiController.class);

	
	@Value("${author.name}")  
	String name;
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHi(@RequestParam String name){
		LOGGER.info("beggin say hi  ... ");
		return "hi from gateway ";		
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String author(){
		LOGGER.info("author name : "+name);
		return name;		
	}

}
