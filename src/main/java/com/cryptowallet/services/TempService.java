package com.cryptowallet.services;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempService {
    private List<TempUser> users;
    private List<String> currencies;

    public TempService(List<TempUser> users, List<String> currencies) {
        this.users = new ArrayList<>();
        this.currencies = new ArrayList<>();
    }

    @PostConstruct
    public void  init() {
        users.add(new TempUser(1L, "Currency1", "Address1", "Token1"));
        users.add(new TempUser(2L, "Currency2", "Address2", "Token2"));
        users.add(new TempUser(3L, "Currency3", "Address3", "Token3"));
        users.add(new TempUser(4L, "Currency4", "Address4", "Token4"));
        users.add(new TempUser(5L, "Currency5", "Address5", "Token5"));
    }

    public List<TempUser> getAllUsers() {
        return users;
    }

    @Data
    class TempUser {
        private Long id;
        private String currency;
        private String address;
        private String token;

        public TempUser(Long id, String currency, String address, String token) {
            this.id = id;
            this.currency = currency;
            this.address = address;
            this.token = token;
        }
    }
}
