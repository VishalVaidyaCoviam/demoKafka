package com.example.demoKafka.thread;

import com.example.demoKafka.service.ReadJson;

import com.example.demoKafka.service.impl.ReadJsonImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonThread extends Thread {
    @Autowired
    ReadJsonImpl readJson;
    public void run(){
        try {
            readJson.readJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
