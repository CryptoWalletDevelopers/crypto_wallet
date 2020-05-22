package com.cryptowallet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.security.Principal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@WebAppConfiguration
@TestPropertySource("/application.properties")
public class WalletControllerTest {
    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;
    private Principal principal;

    private String address_to = "TKoKKzqr4TkPgoGmAxH94f3fZKKe9eUPCe";
    private String address_from = "TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn";
    private Long amount = 10L;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        principal = new Principal() {
            @Override
            public String getName() {
                return "email1@mail.ru";
            }
        };
    }

    @Test
    public void walletTest() throws Exception {
        mockMvc.perform(get("http://localhost:8189/wallet/").principal(principal))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewAddressTest() throws Exception {
        mockMvc.perform(post("http://localhost:8189/wallet/new").principal(principal).param("currencyTitle","TRON"))
                .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception{
        mockMvc.perform(post("http://localhost:8189/wallet/update")
                .param("address","TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void TransferTest() throws Exception {
        MockHttpServletRequestBuilder request = post("http://localhost:8189/wallet/transfer")
                .param("address_to",address_to)
                .param("address_from",address_from)
                .param("amount", String.valueOf(amount));
        this.mockMvc.perform(request).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("http://localhost:8189/wallet/get")).andExpect(status().isOk());
    }
    @Test
    public void sendTest() throws Exception {
        mockMvc.perform(get("http://localhost:8189/wallet/send")).andExpect(status().isOk());
    }

}
