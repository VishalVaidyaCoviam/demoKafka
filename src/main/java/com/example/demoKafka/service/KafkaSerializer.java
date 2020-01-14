package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;

import java.io.Closeable;
import java.util.Map;

public interface KafkaSerializer extends Closeable {
    void configure(Map<String ,?> var1,boolean var2);
    byte[] serialize(String var1, Employee var2);

    void close();
}
