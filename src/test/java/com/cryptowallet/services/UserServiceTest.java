package com.cryptowallet.services;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.Matcher;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;

import java.util.Optional;

@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    void isUserExist() {
        Assert.assertTrue(userService.isUserExist("seConD"));            // login
        Assert.assertTrue(userService.isUserExist("secOnd@maiL.Ru"));    // email

        Assert.assertFalse(userService.isUserExist("unknown"));          // unknown or incorrect - not into db
        Assert.assertFalse(userService.isUserExist("PWAPLZvFTXf02"));    // token
    }

    @Test
    void findByToken() {
        Assert.assertEquals("second", userService.findByToken("PWAPLZvFTXf02").get().getLogin());   // token

        Assert.assertFalse(userService.findByToken("pWAPLZvFTXf02").isPresent());                           // bad token (another case)
        Assert.assertFalse(userService.findByToken("seConD").isPresent());                                  // login
        Assert.assertFalse(userService.findByToken("secOnd@maiL.Ru").isPresent());                          // email
        Assert.assertFalse(userService.findByToken("unknown").isPresent());                                 // unknown or incorrect - not into db
    }

    @Test
    void findByLogin() {
        Assert.assertEquals("second", userService.findByLogin("seConD").get().getLogin());         // login

        Assert.assertFalse(userService.findByLogin("secOnd@maiL.Ru").isPresent());                         // email
        Assert.assertFalse(userService.findByLogin("unknown").isPresent());                                // unknown or incorrect - not into db
        Assert.assertFalse(userService.findByLogin("PWAPLZvFTXf02").isPresent());                          // token
    }

    @Test
    void findByEmail() {
        Assert.assertEquals("second", userService.findByEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userService.findByEmail("seConD").isPresent());                                  // login
        Assert.assertFalse(userService.findByEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userService.findByEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void findByLoginOrEmail() {
        Assert.assertEquals("second", userService.findByLoginOrEmail("seConD").get().getLogin());          // login
        Assert.assertEquals("second", userService.findByLoginOrEmail("seCond@maiL.ru").get().getLogin());  // email

        Assert.assertFalse(userService.findByLoginOrEmail("unknown").isPresent());                                 // unknown or incorrect - not into db
        Assert.assertFalse(userService.findByLoginOrEmail("PWAPLZvFTXf02").isPresent());                           // token
    }

    @Test
    void saveUser() {
        User user = createTestUser("test-save-user");

        Assert.assertFalse(userService.findByLogin("test-save-user").isPresent());
        userService.saveUser(user);
        Assert.assertTrue(userService.findByLogin("test-save-user").isPresent());
    }

    @Test
    void removeUser() {
        User user = createTestUser("test-rem-user");

        userService.saveUser(user);
        Assert.assertTrue(userService.isUserExist("test-rem-user"));

        userService.removeUser(user);
        Assert.assertFalse(userService.isUserExist("test-rem-user"));
    }

    @Test
    void generateToken() {
        User user = createTestUser("test-gen-token");

        Assert.assertNull(user.getDate_exp());
        Assert.assertNull(user.getToken());
        Assert.assertFalse(userService.findByLogin("test-gen-token").isPresent());

        userService.generateToken(user);

        Assert.assertNotNull(user.getDate_exp());
        Assert.assertNotNull(user.getToken());
        Assert.assertTrue(userService.findByLogin("test-gen-token").isPresent());

    }

//    ----------------- Create test user -----------------

    private User createTestUser(String name) {
        User user = new User();
        user.setPassword("test-password");
        user.setRole(roleService.getUserRole());
        user.setEmail(name + "_mail@test.test");
        user.setLogin(name);
        return user;
    }
}