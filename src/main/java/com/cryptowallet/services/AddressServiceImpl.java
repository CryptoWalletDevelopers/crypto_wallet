package com.cryptowallet.services;

import com.cryptowallet.entities.Address;
import com.cryptowallet.repositories.AddressRepository;
import com.cryptowallet.services.interfaces.AddressService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(@NonNull AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(@NonNull Address address){
        addressRepository.save(address);
    }

}
