package com.aziru.restworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
