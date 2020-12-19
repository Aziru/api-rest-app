package com.aziru.restworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aziru.restworld.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
