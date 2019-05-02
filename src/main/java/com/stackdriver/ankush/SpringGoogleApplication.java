package com.stackdriver.ankush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class SpringGoogleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringGoogleApplication.class);
	public static void main(String[] args) {
		logger.info("Logging INFO with Logback");
	    logger.error("Logging ERROR with Logback");
		SpringApplication.run(SpringGoogleApplication.class, args);
	}
	

	
}
