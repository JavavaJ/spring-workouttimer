package com.speakplusplus.springworkouttimer.logic;

public class Interval {
    private int minutes;
    private int seconds;

    public Interval() {
    }

    public Interval(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Interval(String interval) {
        parseStr(interval);
    }

    public void parseStr(String interval) {
        if (interval.contains(":")) {
            String[] split = interval.split(":");
            minutes = Integer.parseInt(split[0]);
            seconds = Integer.parseInt(split[1]);
        } else {
            minutes = Integer.parseInt(interval);
            seconds = 0;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
