package com.speakplusplus.springworkouttimer.command;

import com.speakplusplus.springworkouttimer.logic.Interval;
import com.speakplusplus.springworkouttimer.logic.Sender;

public class SetIntervalCommand implements Command {

    private Interval interval;
    private Sender sender;
    private String text;
    private Long chatId;

    public SetIntervalCommand(Sender sender, Long chatId) {
        super();
        this.sender = sender;
        this.chatId = chatId;
        text = "Interval is set";
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void execute() {
        sender.setInterval(interval);
        sender.sendMessage(getText(), chatId);
    }

}

