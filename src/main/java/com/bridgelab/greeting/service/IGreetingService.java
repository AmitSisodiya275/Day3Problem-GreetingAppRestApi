package com.bridgelab.greeting.service;

import java.util.List;

import com.bridgelab.greeting.model.Greeting;
import com.bridgelab.greeting.model.User;

public interface IGreetingService {

	Greeting addGreeting(User user);

	Greeting getGreetingById(long id);

	List<Greeting> getAllGreeting();

	void deleteGreeting(long id);

	Greeting updateGreeting(long id, User user);
}
