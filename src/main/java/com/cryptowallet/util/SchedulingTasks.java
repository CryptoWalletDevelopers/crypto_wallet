package com.cryptowallet.util;

import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@EnableScheduling
public class SchedulingTasks {

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;


    @Scheduled(fixedRate = MINUTE)
    public void reportPrice() {

    }
}
