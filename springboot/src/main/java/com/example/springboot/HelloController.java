package com.example.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public ResponseEntity<MyResponse> getData(){
		MyResponse resp = new MyResponse();
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("Successfully got the response");
		return new ResponseEntity<MyResponse>(resp,HttpStatus.OK);
	}

}
