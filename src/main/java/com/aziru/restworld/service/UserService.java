package com.aziru.restworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.User;
import com.aziru.restworld.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Create a new user
	 *
	 * @param user
	 * @return
	 */
	public User createUser(final User user) {
		return userRepository.save(user);
	}

	/**
	 * Delete a existing user by id
	 *
	 * @param user
	 */
	public void deleteUser(final Integer userId) {
		userRepository.deleteById(userId);
	}

	/**
	 * @param size
	 * @param page
	 * @return the users
	 */
	public Page<String> getUsersNames(final int page, final int size) {
		return userRepository.findUserNames(PageRequest.of(page, size));
	}

	/**
	 * @param size
	 * @param page
	 * @return the users
	 */
	public Page<User> getUsers(final int page, final int size) {
		return userRepository.findAll(PageRequest.of(page, size));
	}

	/**
	 * Get user by user name
	 *
	 * @param username
	 * @return
	 */
	public User getUserByUserName(final String username) {
		return userRepository.findByUserName(username);
	}

	/**
	 * Get user by user id
	 *
	 * @param username
	 * @return
	 */
	public User getUserById(final Integer userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id %s not found", userId)));
	}

	/**
	 * Get user by user and password
	 *
	 * @param user
	 * @return
	 */
	public User getUserByUserNameAndPassword(final User user) {
		return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}
}
