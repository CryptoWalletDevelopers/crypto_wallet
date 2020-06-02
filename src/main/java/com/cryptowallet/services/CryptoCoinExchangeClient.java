package com.cryptowallet.services;

import com.cryptowallet.entities.dto.cryptoCoinDTO.DataCryptoExchangeResponse;
import com.cryptowallet.entities.dto.cryptoCoinDTO.DataDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Log4j2
@Component
public class CryptoCoinExchangeClient {

    private final String START_PARAMETER = "start";
    private final String LIMIT_PARAMETER = "limit";
    private final String CRYPTOCURRENCY_TYPE = "cryptocurrency_type";
    private final String SORT_PARAMETER = "sort";
    private int default_limit = 10;

    @Value("${coinMarketCap.api.key}")
    private String apiKey;

    @Value("${coinMarketCap.api.uri}")
    private String uri;

    @Value("${coinMarketCap.cmc.api}")
    private String cmcApi;

    private  HttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<DataDTO> getCryptoCoins(Map<String,String> params){
        List<NameValuePair> parameters = new ArrayList<>();
        if(params.isEmpty()){
            params.put(LIMIT_PARAMETER, String.valueOf(default_limit));
        }
        parameters.add(new BasicNameValuePair(START_PARAMETER,"1"));
        parameters.add(new BasicNameValuePair(LIMIT_PARAMETER,params.get(LIMIT_PARAMETER)));
        parameters.add(new BasicNameValuePair(CRYPTOCURRENCY_TYPE,"coins"));
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.add(cmcApi, apiKey);
        HttpEntity request = new HttpEntity(headers);
        try {
            URIBuilder query = new URIBuilder(uri);
            query.addParameters(parameters);
            ResponseEntity<DataCryptoExchangeResponse> response = restTemplate.exchange(
                    query.build(),
                    HttpMethod.GET,
                    request,
                    DataCryptoExchangeResponse.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("Request Successful.");
                return Objects.requireNonNull(response.getBody()).getDataDTO();
            } else {
                log.error("Request Failed.");
                throw new RuntimeException("Request Failed.");
            }
        }catch(URISyntaxException e){
            log.error(e);
            throw new RuntimeException(e);
        }
    }
}
