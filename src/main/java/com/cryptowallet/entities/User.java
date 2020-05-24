package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column
    private String token;

    @Column
    private boolean approved;

    @Column(name = "date_exp")
    private Date dateExpired;

    public User(String login, String password, String email, boolean approved) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.approved = approved;
    }

    @PostConstruct
    public void init(){
        addresses = new ArrayList<>();
    }

    @OneToMany(mappedBy =  "user", fetch = FetchType.EAGER)
    private Collection<Address> addresses;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
