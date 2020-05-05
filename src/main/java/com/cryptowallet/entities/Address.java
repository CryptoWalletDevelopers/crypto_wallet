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

    @Column
    private int index;

    @Column
    private String address;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_currency")
    private Currency currency;
}
