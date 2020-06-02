package com.cryptowallet.util;

import com.cryptowallet.entities.CryptoCoin;
import com.cryptowallet.services.implementations.CryptoPriceServiceImpl;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Log4j2
@NoArgsConstructor
@EnableScheduling
public class SchedulingTasks {

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;

    //NOT USE YET
    @Scheduled(fixedRate = MINUTE)
    public void refresh() {
        log.info("Scheduling is run " + System.currentTimeMillis());
    }
}
