package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.RoleService;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.*;
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
class UserServiceFacadeTest {

    @Autowired
    private UserServiceFacade facade;
    @Autowired
    private RoleService roleService;

    @Test
    void findUser() throws Exception {
        User testUser = new User();
        testUser.setLogin("firSt");

        Assert.assertEquals("first", facade.findUser(testUser.getLogin()).getLogin());
        Assert.assertEquals("first", facade.findUser("FiRsT").getLogin());
        Assert.assertEquals("second@mail.ru", facade.findUser("second").getEmail());
        Assert.assertNull("unknown", facade.findUser("UNKNOWN_USER"));
    }

    @Test
    void isUserExist() {
        Assert.assertTrue(facade.isUserExist("seConD"));            // login
        Assert.assertTrue(facade.isUserExist("secOnd@maiL.Ru"));    // email

        Assert.assertFalse(facade.isUserExist("unknown"));          // unknown or incorrect - not into db
        Assert.assertFalse(facade.isUserExist("PWAPLZvFTXf02"));    // token
    }

    @Test
    void findByLogin() {
        Assert.assertEquals("second", facade.findByLogin("seConD").getLogin());         // login

        Assert.assertNull("second",facade.findByLogin("secOnd@maiL.Ru").getLogin());    // email
        Assert.assertNull("second",facade.findByLogin("unknown").getLogin());           // unknown or incorrect - not into db
        Assert.assertNull("second",facade.findByLogin("PWAPLZvFTXf02").getLogin());     // token
    }

    @Test
    void findByToken() {
        Assert.assertEquals("second",facade.findByToken("PWAPLZvFTXf02").getLogin());   // token

        Assert.assertNull("second", facade.findByToken("seConD").getLogin());           // login
        Assert.assertNull("second",facade.findByToken("secOnd@maiL.Ru").getLogin());    // email
        Assert.assertNull("second",facade.findByToken("unknown").getLogin());           // unknown or incorrect - not into db
    }

    @Test
    void restorePassword() {
    }

    @Test
    void sendActiveCodeToMail() {
    }

    @Test
    void createNewUser() {
        User user = new User();
        user.setLogin("TestUser");
        user.setPassword("123123");
        user.setEmail("Test@mail.ru");
        user.setRole(roleService.getUserRole());
        facade.createNewUser(user);
        Assert.assertEquals("testuser", facade.findUser(user.getLogin()).getLogin());
    }

    @Test
    void activateUser() {
    }

    @Test
    void updatePassword() {
    }

    @Test
    void clearFields() {
    }
}