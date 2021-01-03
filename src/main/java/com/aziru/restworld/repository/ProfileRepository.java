package com.aziru.restworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    @Query("SELECT p FROM Profile p WHERE p.user.id = ?1 AND p.id = ?2")
    Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);

}
