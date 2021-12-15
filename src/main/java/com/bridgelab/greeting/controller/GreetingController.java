package com.bridgelab.greeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelab.greeting.model.Greeting;
import com.bridgelab.greeting.model.User;
import com.bridgelab.greeting.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@PostMapping("/addGreeting")
	public Greeting addGreeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}

	@GetMapping("/getGreeting/{id}")
	public Greeting getGreeting(@PathVariable long id) {
		return greetingService.getGreetingById(id);
	}

	@GetMapping("/getAllGreeting")
	public List<Greeting> getAllGreeting() {
		return greetingService.getAllGreeting();
	}

	@DeleteMapping("/deleteGreeting/{id}")
	public void deleteGreeting(@PathVariable long id) {
		greetingService.deleteGreeting(id);
	}

	@PutMapping("/updateGreeting/{id}/{firstName}/{lastName}")
	public Greeting updateGreeting(@PathVariable long id, @PathVariable String firstName,
			@PathVariable String lastName) {
		User user = new User(firstName, lastName);
		return greetingService.updateGreeting(id, user);
	}
}
