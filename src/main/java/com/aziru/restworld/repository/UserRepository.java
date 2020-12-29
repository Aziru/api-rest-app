package com.aziru.restworld.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);

    Optional<User> findByUserNameAndPassword(String username, String password);

    @Query("SELECT u.userName FROM User u")
    Page<String> findUserNames(Pageable pageable);
}
