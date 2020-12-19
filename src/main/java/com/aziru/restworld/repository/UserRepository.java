package com.aziru.restworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
