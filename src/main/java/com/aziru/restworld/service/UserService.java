package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * @return the users
	 */
	public List<User> getUsers(final String startWith) {
		return userRepository.findAll();
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
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id %s nor found", userId)));
	}

	/**
	 * Create a new user
	 *
	 * @param user
	 * @return
	 */
	public User createUser(final User user) {
		return userRepository.save(user);
	}

//	/**
//	 * Delete a existing user by id
//	 *
//	 * @param user
//	 */
	public void deleteUser(final Integer userId) {
		userRepository.deleteById(userId);
	}

//	/**
//	 * Update a existing user
//	 *
//	 * @param user
//	 * @return
//	 */
//	public User updateUser(final String username, final User user) {
//		final var userToBeUpdate = getUserByUserName(username);
//		userToBeUpdate.setUserName(user.getUserName());
//		userToBeUpdate.setPassword(user.getPassword());
//		return userToBeUpdate;
//
//	}
//

}
