package com.example.demoKafka.deserializer;

import com.example.demoKafka.entity.Employee;

import java.util.Map;

public interface PostgresDeserializer {

        void configure(Map<String, ?> var1, boolean var2);
        Employee deserialize(byte[] var2);
        void close();
    }
