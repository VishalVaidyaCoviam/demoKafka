package com.example.demoKafka.repository;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.entity.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryMongoDB extends MongoRepository<EmployeeMongo,String> {

}
