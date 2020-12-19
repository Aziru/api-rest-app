package com.aziru.restworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
