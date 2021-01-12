package com.aziru.restworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.entity.User;
import com.aziru.restworld.entity.UserInRole;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole, Integer> {

    @Query("SELECT u.user FROM UserInRole u WHERE u.role.name = UPPER(?1) ORDER BY u.user.id")
    public List<User> findUsersInRoleByRoleName(String roleName);

    @Query("SELECT u.role FROM UserInRole u WHERE u.user.id = ?1")
    public List<Role> findByUser(Integer userId);

}
