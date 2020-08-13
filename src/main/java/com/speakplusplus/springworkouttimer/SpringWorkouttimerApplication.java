package com.speakplusplus.springworkouttimer;

import com.speakplusplus.springworkouttimer.logic.TelegramTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class SpringWorkouttimerApplication {

    @Autowired
    private TelegramTimer telegramTimer;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(SpringWorkouttimerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(telegramTimer);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
