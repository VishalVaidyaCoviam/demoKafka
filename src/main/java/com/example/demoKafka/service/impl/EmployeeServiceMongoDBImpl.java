package com.example.demoKafka.service.impl;


import com.example.demoKafka.deserializer.MongoDeserializer;
import com.example.demoKafka.entity.EmployeeMongo;
import com.example.demoKafka.repository.RepositoryMongoDB;
import com.example.demoKafka.service.EmployeeServiceMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceMongoDBImpl implements EmployeeServiceMongoDB {

    @Autowired
    RepositoryMongoDB repositoryMongoDB;


    @Autowired
    MongoDeserializer mongoDeserializer;

    @KafkaListener(topics = "test",groupId = "group")
    public void kafkaToMongo(byte[] var){

        EmployeeMongo employeeMongo = mongoDeserializer.deserialize(var);
        repositoryMongoDB.insert(employeeMongo);
    }
}
