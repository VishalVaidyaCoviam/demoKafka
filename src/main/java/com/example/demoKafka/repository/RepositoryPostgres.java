package com.example.demoKafka.repository;


import com.example.demoKafka.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostgres extends CrudRepository<Employee,String> {
}
