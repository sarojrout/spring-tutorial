package com.example.springcouchbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringcouchbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcouchbaseApplication.class, args);
	}
}
