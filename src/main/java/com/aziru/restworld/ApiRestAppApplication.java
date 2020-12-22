package com.aziru.restworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aziru.restworld.entity.User;
import com.aziru.restworld.repository.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class ApiRestAppApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository userRepository;

	public static void main(final String[] args) {
		SpringApplication.run(ApiRestAppApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		for (var i = 0; i < 100; i++) {
			final var user = new User();
			user.setNickName(faker.funnyName().name());
			user.setUserName(faker.name().username());
			user.setPassword(faker.dragonBall().character());

			userRepository.save(user);
		}
	}
}
