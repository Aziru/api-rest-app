package com.aziru.restworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
