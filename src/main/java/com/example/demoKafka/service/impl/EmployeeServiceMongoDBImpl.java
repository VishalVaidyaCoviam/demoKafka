package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.repository.RepositoryMongoDB;
import com.example.demoKafka.service.EmployeeServiceMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceMongoDBImpl implements EmployeeServiceMongoDB {

    @Autowired
    RepositoryMongoDB repositoryMongoDB;

    @KafkaListener(topics = "test")
    public void kafkaToMongo(Employee employee){
        repositoryMongoDB.insert(employee);
    }
}