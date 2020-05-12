package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private int index;

    @Column(nullable = false)
    private String address;

    public Address (User user, Currency currency, int index, String address) {
        this.user = user;
        this.currency = currency;
        this.index = index;
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_currency")
    private Currency currency;
}
