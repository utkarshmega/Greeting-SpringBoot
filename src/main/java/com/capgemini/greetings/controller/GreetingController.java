package com.capgemini.greetings.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.greetings.model.Greeting;

@RestController
@RequestMapping("/home")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/post")
	public Greeting greeting(@RequestBody Greeting greeting) {
		greeting.setId(counter.incrementAndGet());
		return greeting;
	}
	
	@PutMapping("/put/{id}")
	public Greeting greeting(@PathVariable long id, @RequestParam(value = "name") String name) {
		return new Greeting(id, String.format(template, name));
	}
}
	

