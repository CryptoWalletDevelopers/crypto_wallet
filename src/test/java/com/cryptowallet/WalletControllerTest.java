package com.cryptowallet;

import com.cryptowallet.controller.WalletController;
import com.cryptowallet.services.interfaces.AddressService;
import com.cryptowallet.services.interfaces.CurrencyService;
import com.cryptowallet.services.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {WalletController.class})
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class WalletControllerTest {
    @Autowired
    private WalletController walletController;

    @MockBean
    private UserService userService;
    @MockBean
    private AddressService addressService;
    @MockBean
    private CurrencyService currencyService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getNewAddressTest() throws Exception {
//        User user = new User("login","pass","email",true);
//        userService.save(user);
//        mvc.perform(post("/wallet/new"))
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/wallet/new"));
    }


}
