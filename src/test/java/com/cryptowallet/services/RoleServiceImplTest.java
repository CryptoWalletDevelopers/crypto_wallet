package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.services.implementations.RoleServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashSet;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
class RoleServiceImplTest {
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @BeforeEach
    public void initTest() {
        Role role = new Role();
        role.setTitle("ROLE_USER");
        roleServiceImpl.save(role);
    }

    @Test
    void getRoleById() {
        Assert.assertEquals("ROLE_USER", roleServiceImpl.getRoleById(1).get().getTitle());
    }

    @Test
    void getRolesCollection() {
        Collection<Role> roles = new HashSet<>();
        roles.add(roleServiceImpl.getRoleById(1).get());

        Assert.assertArrayEquals(
                roles.toArray(),
                roleServiceImpl.addToCollection(roleServiceImpl.getRoleById(1).get()).toArray()
        );
    }

    @Test
    void getUserRole() {
        Assert.assertEquals("ROLE_USER", roleServiceImpl.getUserRole().getTitle());
    }
}