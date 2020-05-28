package com.cryptowallet.configuration;

import lombok.extern.log4j.Log4j2;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Log4j2
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public ApplicationListener<ContextRefreshedEvent> startupLoggingListener() {
        return event -> {
            String startMessage = "\033[1;32m" + "\n\n" +
                    "===========================\n" +
                    "╔═══╗╔════╗╔═══╗╔═══╗╔════╗\n" +
                    "║╔═╗║║╔╗╔╗║║╔═╗║║╔═╗║║╔╗╔╗║\n" +
                    "║╚══╗╚╝║║╚╝║║ ║║║╚═╝║╚╝║║╚╝\n" +
                    "╚══╗║  ║║  ║╚═╝║║╔╗╔╝  ║║\n" +
                    "║╚═╝║  ║║  ║╔═╗║║║║╚╗  ║║\n" +
                    "╚═══╝  ╚╝  ╚╝ ╚╝╚╝╚═╝  ╚╝\n" +
                    "===========================\n";
            log.info(startMessage);
            RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
            log.info(mxBean.getInputArguments().toString());
            log.info("Application Has Started->");
        };
    }
}