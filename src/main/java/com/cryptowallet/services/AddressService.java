package com.cryptowallet.services;

import com.cryptowallet.entities.Address;
import com.cryptowallet.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void save(Address address){
       addressRepository.save(address);
    }


}
