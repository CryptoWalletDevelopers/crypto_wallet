package com.cryptowallet.exchangerateAPI;

import com.cryptowallet.exchangerate.API.ExchangeRateAPI;
import com.cryptowallet.exchangerate.service.ExchangeRateAPIServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExchangeRateAPIService {

    @Autowired
    private ExchangeRateAPIServiceImpl apiService;

    @Mock
    private ExchangeRateAPI exchangeRateAPI;

    @Test()
    public void testGetListCoinInfoValid () {
        System.out.println(apiService.getListCoinInfo(0, 20));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetListCoinInfoInvalid () {
        System.out.println(apiService.getListCoinInfo(0, 0));
//        System.out.println(apiService.getListCoinInfo(0, 2500));
//        System.out.println(apiService.getListCoinInfo(2500, 20));
    }

}
