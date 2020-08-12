package com.speakplusplus.springworkouttimer.logic;

import com.speakplusplus.springworkouttimer.command.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Sender {

    private Interval interval;
    private TelegramTimer telegramTimer;
    private CommandProcessor processor;
    private static final String DEFAULT_INTERVAL = "0:00";

    public Sender(TelegramTimer telegramTimer) {
        this.telegramTimer = telegramTimer;
        processor = new CommandProcessor(this);
        interval = new Interval(DEFAULT_INTERVAL);
    }

    public void sendResponse(String text, Long chatId) {
        Command command = processor.getCommand(text, chatId);
        command.execute();
    }

    public void sendMessage(String text, Long chatId) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);

        try {
            telegramTimer.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }
}
