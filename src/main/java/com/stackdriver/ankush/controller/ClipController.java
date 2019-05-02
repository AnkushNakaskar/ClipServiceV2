package com.stackdriver.ankush.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/clip")
public class ClipController  {

	 private static final Logger logger =LoggerFactory.getLogger(ClipController.class);

	
	@GetMapping(value = "/{id}")
	public String testLogging(@PathVariable Long id) {
		logger.info("This is Info logger for With dockerimagetestingAnkushstackdriverlogs..!!!");
		return "Success.. Version 2    ......!!";
	}


}
