
package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;

/**
 * @author Jonsy
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
      
    }
}
