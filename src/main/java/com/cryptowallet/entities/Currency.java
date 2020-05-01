package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "currency_tbl")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_title")
    private String short_title;

    @Column(name = "precision")
    private int precision;

    @Column(name = "index")
    private int index;

    @Column(name = "logo")
    private String logo;

    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
    private Collection<Node> nodes;
}
