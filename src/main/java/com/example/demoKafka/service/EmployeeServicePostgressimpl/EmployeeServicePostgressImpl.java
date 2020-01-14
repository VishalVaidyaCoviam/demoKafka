package com.example.demoKafka.service.EmployeeServicePostgressimpl;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.repository.RepositoryPostgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServicePostgressImpl {

    @Autowired
    RepositoryPostgress repositoryPostgress;

    @KafkaListener(topics = "test",groupId = "Group")
    public void consumer(Employee employee) throws IOException
    {
        repositoryPostgress.save(employee);
    }

}
