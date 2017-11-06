package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/hello")
	public ResponseEntity<MyResponse> getData(){
		LOGGER.info("hey i am inside the getData() method");
		MyResponse resp = new MyResponse();
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("Successfully got the response");
		return new ResponseEntity<MyResponse>(resp,HttpStatus.OK);
	}

}
