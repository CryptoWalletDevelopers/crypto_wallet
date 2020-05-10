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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPostMailRestorePassword {
    private final String ACTIVATION_MESSAGE = "A letter was sent to your mail. " +
            "Please follow the link in the letter to create a new password";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceFacade userServiceFacade;
    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
    }

    @Test
    public void testPostMailRestorePasswordValid () throws Exception {
        given(userServiceFacade.isUserExist(user.getLogin())).willReturn(true);
        mvc.perform(post("/restorePassword").param("login", user.getLogin()).with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("activeMessage", ACTIVATION_MESSAGE));
        verify(userServiceFacade, times(1)).restorePassword(user.getLogin());
    }

    @Test
    public void testPostMailRestorePasswordUserDontExist () throws Exception {
        given(userServiceFacade.isUserExist(user.getLogin())).willReturn(false);
        mvc.perform(post("/restorePassword").param("login", user.getLogin()).with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(content().string(containsString("Input yor email to restore password")));
    }

    @Test
    public void testPostMailRestorePasswordNotValidLogin () throws Exception {
        user.setLogin("*test/");
        mvc.perform(post("/restorePassword").param("login", user.getLogin()).with(csrf()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(content().string(containsString("Input yor email to restore password")));
    }
}
