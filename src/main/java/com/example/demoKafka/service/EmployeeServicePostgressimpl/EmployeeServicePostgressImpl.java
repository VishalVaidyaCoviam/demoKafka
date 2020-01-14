package com.example.demoKafka.service.EmployeeServicePostgressimpl;

import com.example.demoKafka.deserializer.PostgresDeserializer;
import com.example.demoKafka.entity.Employee;
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

    @KafkaListener(topics = "test",groupId = "group")
    public void consumer(byte[] emp) throws IOException
    {
        Employee employee = postgresDeserializer.deserialize(emp);
        repositoryPostgres.save(employee);
    }

}
