package com.cryptowallet.services;

import com.cryptowallet.entities.Role;
import com.cryptowallet.entities.User;

import com.cryptowallet.services.implementations.RoleServiceImpl;
import com.cryptowallet.services.implementations.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private RoleServiceImpl roleServiceImpl;


    @BeforeEach
    private void initTest() {
        Role role = new Role();
        role.setTitle("ROLE_USER");
        roleServiceImpl.save(role);
        User user = createTestUser("second");
        userServiceImpl.save(user);
    }

    @Test
    void isUserExist() {
        Assert.assertTrue(userServiceImpl.isUserExist("seConD"));            // login
        Assert.assertTrue(userServiceImpl.isUserExist("secOnd@maiL.Ru"));    // email

        Assert.assertFalse(userServiceImpl.isUserExist("unknown"));          // unknown or incorrect - not into db
        Assert.assertFalse(userServiceImpl.isUserExist("PWAPLZvFTXf02"));    // token
    }

    @Test
    void findByToken() {
        Assert.assertEquals("second", userServiceImpl.findByToken("PWAPLZvFTXf02").get().getLogin());   // token

        Assert.assertFalse(userServiceImpl.findByToken("pWAPLZvFTXf02").isPresent());                           // bad token (another case)
        Assert.assertFalse(userServiceImpl.findByToken("seConD").isPresent());                                  // login
        Assert.assertFalse(userServiceImpl.findByToken("secOnd@maiL.Ru").isPresent());                          // email
        Assert.assertFalse(userServiceImpl.findByToken("unknown").isPresent());                                 // unknown or incorrect - not into db
    }

    @Test
    void findByLogin() {
        Assert.assertEquals("second", userServiceImpl.findByLogin("seConD").get().getLogin());         // login

        Assert.assertFalse(userServiceImpl.findByLogin("secOnd@maiL.Ru").isPresent());                         // email
        Assert.assertFalse(userServiceImpl.findByLogin("unknown").isPresent());                                // unknown or incorrect - not into db
        Assert.assertFalse(userServiceImpl.findByLogin("PWAPLZvFTXf02").isPresent());                          // token
    }

    @Test
    void findByEmail() {
        Assert.assertEquals("second", userServiceImpl.findByEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userServiceImpl.findByEmail("seConD").isPresent());                                  // login
        Assert.assertFalse(userServiceImpl.findByEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userServiceImpl.findByEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void findByLoginOrEmail() {
        Assert.assertEquals("second", userServiceImpl.findByLoginOrEmail("seConD").get().getLogin());          // login
        Assert.assertEquals("second", userServiceImpl.findByLoginOrEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userServiceImpl.findByLoginOrEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userServiceImpl.findByLoginOrEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void saveUser() {
        User user = createTestUser("test-save-user");

        Assert.assertFalse(userServiceImpl.findByLogin("test-save-user").isPresent());
        userServiceImpl.saveUser(user);
        Assert.assertTrue(userServiceImpl.findByLogin("test-save-user").isPresent());
    }

    @Test
    void removeUser() {
        User user = createTestUser("test-rem-user");

        userServiceImpl.saveUser(user);
        Assert.assertTrue(userServiceImpl.isUserExist("test-rem-user"));

        userServiceImpl.removeUser(user);
        Assert.assertFalse(userServiceImpl.isUserExist("test-rem-user"));
    }

    @Test
    void generateToken() {
        User user = createTestUser("test-gen-token");

        Assert.assertNull(user.getDateExpired());
        Assert.assertNull(user.getToken());
        Assert.assertFalse(userServiceImpl.findByLogin("test-gen-token").isPresent());

        userServiceImpl.generateToken(user);

        Assert.assertNotNull(user.getDateExpired());
        Assert.assertNotNull(user.getToken());
        Assert.assertTrue(userServiceImpl.findByLogin("test-gen-token").isPresent());

    }

//    ----------------- Create test user -----------------

    private User createTestUser(String name) {
        User user = new User();
        user.setPassword("test-password");
        user.setRole(roleServiceImpl.getUserRole());
        user.setEmail(name + "_mail@test.test");
        user.setLogin(name);
        return user;
    }
}