package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPostSaveNewPassword {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceFacade userServiceFacade;
    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setEmail("test@localhost.com");
        user.setPassword("1234567");
    }

    @Test
    public void testPostSaveNewPasswordValid () throws Exception {
        given(userServiceFacade.isUserExist(user.getEmail())).willReturn(true);
        given(userServiceFacade.findUser(user.getEmail())).willReturn(user);
        mvc.perform(post("/newPassword")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(content().string(containsString("Your password has been successfully saved!")));
        verify(userServiceFacade, times(1)).updatePassword(user, user.getPassword());
    }

    @Test
    public void testPostSaveNewPasswordUserDontExist () throws Exception {
        given(userServiceFacade.isUserExist(user.getEmail())).willReturn(false);
        mvc.perform(post("/newPassword")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(content().string(containsString("User dont exist")));
    }

    @Test
    public void testPostSaveNewPasswordNotValidPassword () throws Exception {
        given(userServiceFacade.isUserExist(user.getEmail())).willReturn(true);
        user.setPassword("123");
        mvc.perform(post("/newPassword")
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(content().string(containsString("New Password")));
    }
}
