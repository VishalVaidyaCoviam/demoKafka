package com.example.demoKafka.deserializer;

import com.example.demoKafka.entity.EmployeeMongo;

import java.io.Closeable;
import java.util.Map;

public interface MongoDeserializer extends Closeable {
    void configoure(Map<String,?> var1, boolean var2);
    EmployeeMongo deserialize(String var2);
    void close();
}
