package com.cryptowallet.TestUserController;

import com.cryptowallet.entities.User;
import com.cryptowallet.services.facades.UserServiceFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class TestGetMethodsSecurityUserControllerImpl {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserServiceFacadeImpl userServiceFacadeImpl;
    private User user;

    @Before
    public void initTest () {
        user = new User ();
        user.setLogin("test");
        user.setEmail("test@localhost.com");
    }


    @Test
    public void testGetSignUp () throws Exception {
        mvc.perform(get("/sign_up"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("user", new User()))
                .andExpect(xpath("/html/body/form").nodeCount(1))
                .andExpect(content().string(containsString("Registration")));
    }

    @Test
    public void testGetRestorePassword () throws Exception {
        mvc.perform(get("/restorePassword"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/form").nodeCount(1))
                .andExpect(content().string(containsString("Restore password")));
    }

    @Test
    public void testGetLogin () throws Exception {
        mvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/html/body/form").nodeCount(1))
                .andExpect(content().string(containsString("Authorisation")));
    }

    @Test
    @WithMockUser(username = "test")
    public void testGetUserProfileIsApproved () throws Exception {
        user.setApproved(true);
        given(userServiceFacadeImpl.findByLogin("test")).willReturn(user);
        mvc.perform(get("/userProfile"))
                .andExpect(authenticated())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Profile")))
                .andExpect(model().size(1))
                .andExpect(model().attribute("user", user))
                .andExpect(xpath("/html/body/div[2]").nodeCount(0));
    }

    @Test
    @WithMockUser(username = "test")
    public void testGetUserProfileIsNotApproved () throws Exception {
        user.setApproved(false);
        given(userServiceFacadeImpl.findByLogin("test")).willReturn(user);
        mvc.perform(get("/userProfile"))
                .andExpect(authenticated())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Profile")))
                .andExpect(model().size(1))
                .andExpect(xpath("/html/body/div[2]").nodeCount(1))
                .andExpect(content().string(containsString("Your account is not activated")))
                .andExpect(model().attribute("user", user));
    }

    @Test
    @WithAnonymousUser
    public void testGetUserProfileWithAnonymousUser () throws Exception {
        mvc.perform(get("/userProfile"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));//почему-то не воспринимает "/login"
    }

    @Test
    @WithMockUser(username = "test")
    public void testGetResendTokenToActivation () throws Exception {
        user.setApproved(false);
        given(userServiceFacadeImpl.findByLogin("test")).willReturn(user);
        mvc.perform(get("/resendTokenToActivation"))
                .andExpect(authenticated())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attribute("user", user))
                .andExpect(xpath("/html/body/div[2]").nodeCount(1))
                .andExpect(content().string(containsString("Your account is not activated")));
        verify(userServiceFacadeImpl, times(1)).sendActiveCodeToMail(user);
    }

}
