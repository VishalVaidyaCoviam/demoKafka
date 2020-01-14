package com.example.demoKafka.deserializer;

import com.example.demoKafka.entity.Employee;

import java.io.Closeable;
import java.util.Map;

public interface PostgresDeserializer extends Closeable {

        void configure(Map<String, ?> var1, boolean var2);
        Employee deserialize(String var2);
        void close();
    }
