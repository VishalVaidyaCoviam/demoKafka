package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.service.KafkaSerializer;
import com.example.demoKafka.service.KafkaServiceCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class KafkaServiceCsvImpl implements KafkaServiceCsv {

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    KafkaSerializer kafkaSerializer;

    public void read() throws IOException {
        String line;
        List<String> details =null;

        BufferedReader br = new BufferedReader(new FileReader("/Users/vaidyavishal/Downloads/demoKafka/src/employee.csv"));
        while((line=br.readLine())!=null)
        {
            details = Arrays.asList(line.split(","));
            Employee emp = new Employee();
            emp.setFirstName(details.get(0));
            emp.setLastName(details.get(1));
            Date date = new Date(details.get(2));
            emp.setDateOfBirth(date);
            emp.setExperience(details.get(3));
//            System.out.println(kafkaSerializer.serialize(TOPIC,emp));
            this.kafkaTemplate.send(TOPIC,kafkaSerializer.serialize(TOPIC,emp));

        }
    }
}
