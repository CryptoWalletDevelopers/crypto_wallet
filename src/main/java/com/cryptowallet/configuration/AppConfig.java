package com.cryptowallet.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Log4j2
@Configuration
@ComponentScan("com.cryptowallet")
public class AppConfig implements WebMvcConfigurer {

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jquery/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.5.0/");

        registry.addResourceHandler("/popper/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/popper.js/2.0.2/umd/");

        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.4.1-1/");
    }
}