package com.speakplusplus.springworkouttimer.logic;

import com.speakplusplus.springworkouttimer.command.Command;
import com.speakplusplus.springworkouttimer.command.SendLaterCommand;
import com.speakplusplus.springworkouttimer.command.SetIntervalCommand;

public class CommandProcessor {

    private Sender sender;

    public CommandProcessor(Sender sender) {
        this.sender = sender;
    }

    public Command getCommand(String text, Long chatId) {
        Command command = null;

        if (text.length() == 0) {
            return command;
        }

        if (text.length() >= 3 && text.charAt(0) == 'S') {
            String intervalStr = text.substring(2);
            Interval interval = new Interval(intervalStr);

            SetIntervalCommand setIntervalCommand = new SetIntervalCommand(sender, chatId);
            setIntervalCommand.setInterval(interval);
            command = setIntervalCommand;
        } else {
            command = new SendLaterCommand(sender, chatId);
        }

        return command;
    }

}
