package com.telstra.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MicroServiceMain {

	
	public static void main(String[] args) {
		log.info("Microservice Application Starts");
		SpringApplication.run(MicroServiceMain.class, args);
		log.info("Microservice Application Ends");
	}

}
