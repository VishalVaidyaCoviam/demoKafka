package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.entity.EmployeeMongo;

public interface EmployeeServiceMongoDB {

    public void kafkaToMongo(String var);
}
