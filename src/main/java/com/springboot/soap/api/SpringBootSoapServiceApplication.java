package com.springboot.soap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value ="/api")
public class SpringBootSoapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapServiceApplication.class, args);
	}
	
	@RequestMapping(value ="/hai")
	public String sayHello() {
		return "Welcome to Spring boot application";
	}

}
