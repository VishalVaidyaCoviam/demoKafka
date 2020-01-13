package com.example.demoKafka.service;

import com.example.demoKafka.entity.Employee;

public interface EmployeeServiceMongoDB {

    public void kafkaToMongo(Employee employee);
}
