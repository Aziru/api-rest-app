package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aziru.restworld.entity.Address;
import com.aziru.restworld.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAddressByUserAndProfile(final Integer userId, final Integer profileId) {
	return addressRepository.findAddressByUserAndProfile(userId, profileId);
    }
}
