package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column(name = "short_title")
    private String shortTitle;

    @Column
    private int precision;

    @Column(nullable = false)
    private int index;

    @Column
    private String logo;

    public Currency(String title, String shortTitle, int index) {
        this.title = title;
        this.shortTitle = shortTitle;
        this.index = index;
    }
    @PostConstruct
    public void init(){
        nodes = new ArrayList<>();
    }

    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
    private Collection<Node> nodes;
}
