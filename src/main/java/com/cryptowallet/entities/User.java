package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "date_exp")
    private String date_exp;

    @Column(name = "activation_code")
    private String activationCode;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_role")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

}
