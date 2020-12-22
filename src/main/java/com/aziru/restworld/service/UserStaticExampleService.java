package com.aziru.restworld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.models.User;
import com.github.javafaker.Faker;

@Service
public class UserStaticExampleService {

	@Autowired
	private Faker faker;

	private final List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (var i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers(final String startWith) {
		if (StringUtils.isNoneEmpty(startWith)) {
			return users.stream().filter(u -> u.getUserName().startsWith(startWith)).collect(Collectors.toList());
		} else {
			return users;
		}
	}

	/**
	 * Get user by user name
	 *
	 * @param username
	 * @return
	 */
	public User getUserByUserName(final String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Usuario no encontrado: %s", username)));
	}

	/**
	 * Create a new user
	 *
	 * @param user
	 * @return
	 */
	public User createUser(final User user) {
		if (users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("El usuario %s ya existe", user.getUserName()));
		}
		users.add(user);
		return user;
	}

	/**
	 * Update a existing user
	 *
	 * @param user
	 * @return
	 */
	public User updateUser(final String username, final User user) {
		final var userToBeUpdate = getUserByUserName(username);
		userToBeUpdate.setUserName(user.getUserName());
		userToBeUpdate.setPassword(user.getPassword());
		return userToBeUpdate;

	}

	/**
	 * Delete a existing user
	 *
	 * @param user
	 */
	public void deleteUser(final String username) {
		users.remove(getUserByUserName(username));
	}
}
