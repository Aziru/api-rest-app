package com.aziru.restworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.UserInRole;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole, Integer> {

    @Query("SELECT u FROM UserInRole u WHERE u.user.id = ?1")
    public List<UserInRole> findUserInRoleByUserId(Integer userId);

}
