package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;
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
public class ReadJson {
    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String,Employee> kafkaTemplate;

//    public void sendEmployee(Employee employee){
//        this.kafkaTemplate.send(TOPIC,employee);
//    }

    public void readJsonFile() throws IOException, ParseException, java.text.ParseException{
        JSONParser parser=new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/vaidyavishal/IdeaProjects/MyControllerDatabase/src/MyController/employee.json"));

        for (Object o : array) {
            JSONObject employee = (JSONObject) o;

            String firstname = (String) employee.get("firstName");

            String lastname = (String) employee.get("lastName");

            String dateOfBirth = (String) employee.get("dateOfBirth");

            String experience = (String) employee.get("experience");

            Employee emp = new Employee();
            emp.setFirstName(firstname);
            emp.setLastName(lastname);
            emp.setExperience(experience);
            emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));

            this.kafkaTemplate.send(TOPIC, emp);

        }
    }
}
