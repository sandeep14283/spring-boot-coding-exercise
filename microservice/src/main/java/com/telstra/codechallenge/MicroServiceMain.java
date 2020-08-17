package com.telstra.codechallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceMain {

	static final Logger log = LoggerFactory.getLogger(MicroServiceMain.class);
	
	public static void main(String[] args) {
		log.info("Microservice Application Starts");
		SpringApplication.run(MicroServiceMain.class, args);
	}

}
