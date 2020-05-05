package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "node")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String ip;

    @Column
    private String port;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_currency")
    private Currency currency;

}
