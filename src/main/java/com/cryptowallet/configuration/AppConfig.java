package com.cryptowallet.configuration;

import lombok.extern.log4j.Log4j2;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Locale;

@Log4j2
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    private final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }


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