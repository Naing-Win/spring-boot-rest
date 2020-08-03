package com.nw.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
	
	@GetMapping
	public String hello() {
		return "Hello Spring Rest!";
	}

}
