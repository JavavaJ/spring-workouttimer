package com.speakplusplus.springworkouttimer.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;

@Component
public class TelegramTimer extends TelegramLongPollingBot {

    private Sender sender;

    @Value("${telegram.botToken}")
    private String botToken;

    public TelegramTimer() {
        super();
        init();
    }

    public String getBotToken() {
//        return "1345007730:AAH-bJQHHal0qKyiqH5g-9SitMjXJg1CP_E";
        return botToken;
    }

    public void onUpdateReceived(Update update) {
        sender.sendResponse(update.getMessage().getText(),
            update.getMessage().getChatId());
    }

    public String getBotUsername() {
        return "WorkoutTimerBot";
    }

    public void init() {
        sender = new Sender(this);
    }
}
