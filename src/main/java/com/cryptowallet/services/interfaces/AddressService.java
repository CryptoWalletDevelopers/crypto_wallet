package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Address;
import com.cryptowallet.repositories.AddressRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public interface AddressService {
    void save(@NonNull Address address);
    Optional<Address> findAddressesByAddress(@NonNull String address);
}
