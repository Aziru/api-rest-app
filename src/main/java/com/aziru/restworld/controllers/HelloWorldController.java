package com.aziru.restworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // stereotype
@RequestMapping("hello")
public class HelloWorldController {

	@GetMapping
	public String helloWorld() {

		return "funcionando";
	}
}
