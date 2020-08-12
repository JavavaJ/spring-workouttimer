package com.speakplusplus.springworkouttimer;

import com.speakplusplus.springworkouttimer.logic.TelegramTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
@EnableScheduling
public class SpringWorkouttimerApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramTimer());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        SpringApplication.run(SpringWorkouttimerApplication.class, args);
    }

}
