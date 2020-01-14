package com.example.demoKafka.thread;

import com.example.demoKafka.service.ReadJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;

@Component
public class JsonThread extends Thread {
    @Autowired
    ReadJson readJson;

    public void run(){
        try {
            readJson.readJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
