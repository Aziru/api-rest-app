package com.aziru.restworld;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.entity.User;
import com.aziru.restworld.entity.UserInRole;
import com.aziru.restworld.repository.RoleRepository;
import com.aziru.restworld.repository.UserInRoleRepository;
import com.aziru.restworld.repository.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class ApiRestAppApplication implements ApplicationRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserInRoleRepository userInRoleRepository;

    private static final Logger log = LoggerFactory.getLogger(ApiRestAppApplication.class);

    public static void main(final String[] args) {
	SpringApplication.run(ApiRestAppApplication.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
	// Loading roles
	final Role roles[] = { new Role("ADMIN"), new Role("USER"), new Role("READONLY") };
	for (final Role role : roles) {
	    roleRepository.save(role);
	}
	// Loading users
	for (var i = 0; i < 100; i++) {
	    final var user = new User();
	    user.setNickName(faker.funnyName().name());
	    user.setUserName(faker.name().username());
	    user.setPassword(faker.dragonBall().character());
	    final var userCreated = userRepository.save(user);
	    final var userInRole = new UserInRole(userCreated, roles[new Random().nextInt(3)]);

	    log.info("User {} with password {} and role {} ", userCreated.getUserName(), userCreated.getPassword(), userInRole.getRole().getName());
	    userInRoleRepository.save(userInRole);
	}
    }
}
