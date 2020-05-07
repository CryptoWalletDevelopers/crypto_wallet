package com.cryptowallet;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.UserRepository;
import com.cryptowallet.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findOneUserTest() {
        User userFromDB = new User();
        userFromDB.setLogin("89380000000");
        userFromDB.setEmail("admin@mail.ru");

        Mockito.doReturn(userFromDB)
                .when(userRepository)
                .findByLogin("89380000000");

        User userJohn = userService.findByLogin("89380000000");
        Assert.assertNotNull(userJohn);
        Mockito.verify(userRepository, Mockito.times(1)).findByLogin(ArgumentMatchers.eq("89380000000"));
    }
}
