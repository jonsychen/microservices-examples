package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service2",fallback = SayHiHystrix.class)
public interface SayHiService {
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	String sayHiToService2(@RequestParam(value = "name") String name);
	
	      
}
