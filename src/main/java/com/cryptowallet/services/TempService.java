package com.cryptowallet.services;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempService {
    private List<TempWallet> wallets;
    private List<TempCurrency> currencies;

    public TempService(List<TempWallet> wallets, List<TempCurrency> currencies) {
        this.wallets = new ArrayList<>();
        this.currencies = new ArrayList<>();
    }

    @PostConstruct
    public void  init() {
        wallets.add(new TempWallet(1L, "Currency1", "Address1", "Token1"));
        wallets.add(new TempWallet(2L, "Currency2", "Address2", "Token2"));
        wallets.add(new TempWallet(3L, "Currency3", "Address3", "Token3"));
        wallets.add(new TempWallet(4L, "Currency4", "Address4", "Token4"));
        wallets.add(new TempWallet(5L, "Currency5", "Address5", "Token5"));

        currencies.add(new TempCurrency(1L, "Currency1"));
        currencies.add(new TempCurrency(2L, "Currency2"));
        currencies.add(new TempCurrency(3L, "Currency3"));
        currencies.add(new TempCurrency(4L, "Currency4"));
        currencies.add(new TempCurrency(5L, "Currency5"));
    }

    public List<TempWallet> getAllWallets() {
        return wallets;
    }

    public List<TempCurrency> getAllCurrencies() {
        return currencies;
    }

    public String getCurrencyById(Long id) {
        return currencies.get(id.intValue()).getTitle();
    }

    public TempWallet addWallet(Long currencyId) {
        String titleCurrency = getCurrencyById(currencyId);
//        String address = generateAddress(currencyId);
        Long newId = new Long(wallets.size()) + 1;
        TempWallet tw = new TempWallet(newId, titleCurrency, "Address" + newId, "Token" + newId);
        wallets.add(tw);
        return tw;
    }

    @Data
    public class TempWallet {
        private Long id;
        private String currency;
        private String address;
        private String token;

        public TempWallet(Long id, String currency, String address, String token) {
            this.id = id;
            this.currency = currency;
            this.address = address;
            this.token = token;
        }
    }

    @Data
    public class TempCurrency {
        private Long id;
        private String title;

        public TempCurrency(Long id, String title) {
            this.id = id;
            this.title = title;
        }
    }
}
