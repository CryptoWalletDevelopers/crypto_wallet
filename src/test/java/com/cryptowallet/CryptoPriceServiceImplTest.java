package com.cryptowallet;

import com.cryptowallet.entities.CryptoCoin;
import com.cryptowallet.services.implementations.CryptoPriceServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
class CryptoPriceServiceImplTest {

    @Value("${coinMarketCap.api.uri}")
    private String uri;
    private Map<String, String> params;
    private List<CryptoCoin> cryptoCoins;

    @Autowired
    private CryptoPriceServiceImpl priceService;

    @Before
    void setUp() {
        params = new HashMap<>();
        params.put("start","1");
        params.put("limit","2");
    }

    @Test
    protected void notFoundPageErrorForGivenAPITest() throws IOException {
        String name = RandomStringUtils.randomAlphabetic( 8 );
        HttpUriRequest request = new HttpGet(uri + name);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    protected void checkAuthorizedClientForGivenAPITest() throws URISyntaxException, IOException {
        URIBuilder query = new URIBuilder(uri);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());
        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", "8311b984-667a-4ebf-9362-f6de0a9da1f0");
        CloseableHttpResponse response = client.execute(request);
        assertThat(
                response.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }
    @Test
    protected void checkCryptoCoinNameExistTest() {
        setUp();
        assertNotNull(priceService.getData(params).get(1).getName());
    }

    @Test
    protected void checkDefaultResponseContentTypeIsJsonTest() throws IOException {
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( uri );
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }
}