package com.example.demoKafka.service.EmployeeServicePostgressimpl;

import com.example.demoKafka.deserializer.MongoDeserializer;
import com.example.demoKafka.deserializer.PostgresDeserializer;
import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.entity.EmployeeMongo;
import com.example.demoKafka.repository.RepositoryMongoDB;
import com.example.demoKafka.repository.RepositoryPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServicePostgressImpl {

    @Autowired
    RepositoryPostgres repositoryPostgres;


    @Autowired
    PostgresDeserializer postgresDeserializer;

    @Autowired
    RepositoryMongoDB repositoryMongoDB;

    @Autowired
    MongoDeserializer mongoDeserializer;

    private static int counter=0;

    @KafkaListener(topics = "test",groupId = "group",topicPartitions = )
    public void consumer(String emp)
    {
        if(counter%2==0){

        Employee employee = postgresDeserializer.deserialize(emp);
        repositoryPostgres.save(employee);

        }
        else {
            EmployeeMongo employeeMongo = mongoDeserializer.deserialize(emp);
            repositoryMongoDB.save(employeeMongo);

        }
        counter++;
    }

}
