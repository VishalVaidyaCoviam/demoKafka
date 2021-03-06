package com.example.demoKafka.deserializer.impl;

import com.example.demoKafka.deserializer.PostgresDeserializer;
import com.example.demoKafka.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class PostgresDeserializerImpl implements PostgresDeserializer {

    @Override
    public void configure(Map<String, ?> var1, boolean var2) {

    }

    @Override
    public Employee deserialize( String var2) {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = null;
        try {
            employee = mapper.readValue(var2 , Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void close() {

    }
}
