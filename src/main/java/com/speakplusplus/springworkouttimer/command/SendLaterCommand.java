package com.speakplusplus.springworkouttimer.command;

import com.speakplusplus.springworkouttimer.logic.Sender;

public class SendLaterCommand implements Command {

    private Sender sender;
    private String text;
    private Long chatId;

    public SendLaterCommand(Sender sender, Long chatId) {
        super();
        this.sender = sender;
        this.chatId = chatId;
        text = "Time is up";
    }

    @Override
    public String getText() {
        return text;
    }

    public void execute() {
        waitInterval();
        sender.sendMessage(getText(), chatId);
    }

    private void waitInterval() {
        long sendInMillis = (
            (sender.getInterval().getMinutes() * 60)
                + sender.getInterval().getSeconds()
        )
            * 1000;
        try {
            Thread.sleep(sendInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

