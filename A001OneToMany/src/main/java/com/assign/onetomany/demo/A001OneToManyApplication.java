package com.assign.onetomany.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan("com.assign.onetomany")
public class A001OneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(A001OneToManyApplication.class, args);
	}

	
}
