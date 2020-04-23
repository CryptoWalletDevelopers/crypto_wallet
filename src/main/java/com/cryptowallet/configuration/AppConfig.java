package com.cryptowallet.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
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
}