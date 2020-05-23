package com.cryptowallet.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "role_tbl")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Collection<User> users;

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Role role = (Role) obj;
        return Objects.equals(id, role.id) && Objects.equals(title, role.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
