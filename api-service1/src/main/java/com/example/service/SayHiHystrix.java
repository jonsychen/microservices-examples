package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SayHiHystrix implements SayHiService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SayHiHystrix.class);

	@Override
	public String sayHiToService2(String name) {
		LOGGER.info("...................................");
		LOGGER.info("in error handler ...");
		return "error";
	}

}
