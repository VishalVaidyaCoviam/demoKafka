package com.example.demoKafka.repository;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.entity.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMongoDB extends MongoRepository<EmployeeMongo,String> {

}
