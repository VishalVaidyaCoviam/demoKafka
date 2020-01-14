package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.service.KafkaSerializer;
import com.example.demoKafka.service.ReadJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Service
public class ReadJsonImpl implements ReadJson {

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaSerializer kafkaSerializer;

    public void readJsonFile() throws IOException, ParseException, java.text.ParseException{
        JSONParser parser=new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/vaidyavishal/IdeaProjects/MyControllerDatabase/src/MyController/employee.json"));


        for (Object o : array) {
            JSONObject employee = (JSONObject) o;

            String firstname = (String) employee.get("firstName");

            String lastname = (String) employee.get("lastName");

            String dateOfBirth = (String) employee.get("dateOfBirth");

            Long experience = (Long) employee.get("experience");

            Employee emp = new Employee();
            emp.setFirstName(firstname);
            emp.setLastName(lastname);
            emp.setExperience(experience.toString());
            emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));
//            System.out.println(kafkaSerializer.serialize(TOPIC,emp));

            this.kafkaTemplate.send(TOPIC,kafkaSerializer.serialize(TOPIC,emp));

        }
    }
}
