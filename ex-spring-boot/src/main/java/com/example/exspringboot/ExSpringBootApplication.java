package com.example.exspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExSpringBootApplication {

	public static void main(String[] args) { SpringApplication.run(ExSpringBootApplication.class, args); }

	@GetMapping("/hello")
	public String greeting(){ return "Hello"; }
}
