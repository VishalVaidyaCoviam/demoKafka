package com.example.demoKafka.deserializer.impl;

import com.example.demoKafka.deserializer.MongoDeserializer;
import com.example.demoKafka.entity.EmployeeMongo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class MongoDeserializaer implements MongoDeserializer {

    @Override
    public void configoure(Map<String, ?> var1, boolean var2) {

    }

    @Override
    public EmployeeMongo deserialize(String var2) {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeMongo employeeMongo = null;
        try {
            employeeMongo = objectMapper.readValue(var2, EmployeeMongo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeMongo;
    }

    @Override
    public void close() {

    }
}
