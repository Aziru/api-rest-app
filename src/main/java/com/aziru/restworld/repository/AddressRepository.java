package com.aziru.restworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Query("SELECT a FROM address a WHERE a.profile.user.id = ?1 and a.profile.id = ?2")
    List<Address> findAddressByUserAndProfile(Integer userId, Integer profileId);

}
