package com.cryptowallet.services.interfaces;

import com.cryptowallet.entities.Address;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AddressService {
    void save(@NonNull Address address);
    Optional<Address> findAddressesByAddress(@NonNull String address);
}
