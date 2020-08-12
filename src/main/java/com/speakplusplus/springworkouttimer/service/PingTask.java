package com.speakplusplus.springworkouttimer.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class PingTask {

//    @Scheduled(fixedRate = 1800000)
    @Scheduled(fixedRate = 18000)
    public void pingMe() {
        String urlStr = "https://www.google.com";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            System.out.println("Connected");
            connection.disconnect();
            System.out.println("Disconnected");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
