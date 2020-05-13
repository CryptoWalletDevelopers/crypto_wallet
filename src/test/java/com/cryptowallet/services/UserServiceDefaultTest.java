package com.cryptowallet.services;

import com.cryptowallet.entities.User;

import lombok.extern.log4j.Log4j2;
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
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class UserServiceDefaultTest {
    @Autowired
    private UserServiceDefault userServiceDefault;
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Test
    void isUserExist() {
        Assert.assertTrue(userServiceDefault.isUserExist("seConD"));            // login
        Assert.assertTrue(userServiceDefault.isUserExist("secOnd@maiL.Ru"));    // email

        Assert.assertFalse(userServiceDefault.isUserExist("unknown"));          // unknown or incorrect - not into db
        Assert.assertFalse(userServiceDefault.isUserExist("PWAPLZvFTXf02"));    // token
    }

    @Test
    void findByToken() {
        Assert.assertEquals("second", userServiceDefault.findByToken("PWAPLZvFTXf02").get().getLogin());   // token

        Assert.assertFalse(userServiceDefault.findByToken("pWAPLZvFTXf02").isPresent());                           // bad token (another case)
        Assert.assertFalse(userServiceDefault.findByToken("seConD").isPresent());                                  // login
        Assert.assertFalse(userServiceDefault.findByToken("secOnd@maiL.Ru").isPresent());                          // email
        Assert.assertFalse(userServiceDefault.findByToken("unknown").isPresent());                                 // unknown or incorrect - not into db
    }

    @Test
    void findByLogin() {
        Assert.assertEquals("second", userServiceDefault.findByLogin("seConD").get().getLogin());         // login

        Assert.assertFalse(userServiceDefault.findByLogin("secOnd@maiL.Ru").isPresent());                         // email
        Assert.assertFalse(userServiceDefault.findByLogin("unknown").isPresent());                                // unknown or incorrect - not into db
        Assert.assertFalse(userServiceDefault.findByLogin("PWAPLZvFTXf02").isPresent());                          // token
    }

    @Test
    void findByEmail() {
        Assert.assertEquals("second", userServiceDefault.findByEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userServiceDefault.findByEmail("seConD").isPresent());                                  // login
        Assert.assertFalse(userServiceDefault.findByEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userServiceDefault.findByEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void findByLoginOrEmail() {
        Assert.assertEquals("second", userServiceDefault.findByLoginOrEmail("seConD").get().getLogin());          // login
        Assert.assertEquals("second", userServiceDefault.findByLoginOrEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userServiceDefault.findByLoginOrEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userServiceDefault.findByLoginOrEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void saveUser() {
        User user = createTestUser("test-save-user");

        Assert.assertFalse(userServiceDefault.findByLogin("test-save-user").isPresent());
        userServiceDefault.saveUser(user);
        Assert.assertTrue(userServiceDefault.findByLogin("test-save-user").isPresent());
    }

    @Test
    void removeUser() {
        User user = createTestUser("test-rem-user");

        userServiceDefault.saveUser(user);
        Assert.assertTrue(userServiceDefault.isUserExist("test-rem-user"));

        userServiceDefault.removeUser(user);
        Assert.assertFalse(userServiceDefault.isUserExist("test-rem-user"));
    }

    @Test
    void generateToken() {
        User user = createTestUser("test-gen-token");

        Assert.assertNull(user.getDateExpired());
        Assert.assertNull(user.getToken());
        Assert.assertFalse(userServiceDefault.findByLogin("test-gen-token").isPresent());

        userServiceDefault.generateToken(user);

        Assert.assertNotNull(user.getDateExpired());
        Assert.assertNotNull(user.getToken());
        Assert.assertTrue(userServiceDefault.findByLogin("test-gen-token").isPresent());

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