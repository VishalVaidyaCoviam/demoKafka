//package com.example.demoKafka.service.impl;
//
//import com.example.demoKafka.deserializer.MongoDeserializer;
//import com.example.demoKafka.entity.EmployeeMongo;
//import com.example.demoKafka.repository.RepositoryMongoDB;
//import com.example.demoKafka.service.EmployeeServiceMongoDB;
//import oracle.jvm.hotspot.jfr.Producer;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.logging.Logger;
//
//@Service
//public class EmployeeServiceMongoDBImpl {
//
//    @Autowired
//    RepositoryMongoDB repositoryMongoDB;
//
//
//    @Autowired
//    MongoDeserializer mongoDeserializer;
//
//    private static int counter=0;
//
//
//    @KafkaListener(topics = "test",groupId = "group")
//    public void kafkaToMongo(String var){
//        if(counter<150){
//            System.out.println(var);
//        EmployeeMongo employeeMongo = mongoDeserializer.deserialize(var);
//        repositoryMongoDB.save(employeeMongo);
//        counter++;
//        }
//    }
//
//
//}
