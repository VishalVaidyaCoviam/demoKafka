package com.example.demoKafka.thread;

import com.example.demoKafka.service.KafkaServiceCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CsvThread extends Thread {
    @Autowired
    KafkaServiceCsv kafkaServiceCsv;
    public void run()
    {
        try {
            kafkaServiceCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
