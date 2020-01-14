package com.example.demoKafka.controller;

import com.example.demoKafka.thread.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    CsvThread csvThread;
    @Autowired
    JsonThread jsonThread;
    @Autowired
    XmlThread xmlThread;
    @GetMapping(value="/ReadAndWrite")
    public void readAndWrite()  {
//        CsvThread csvThread = new CsvThread();


//        JsonThread jsonThread = new JsonThread();
//        XmlThread xmlThread = new XmlThread();
        csvThread.start();
        jsonThread.start();
        xmlThread.start();

//        csvThread.join();
//        jsonThread.join();
//        xmlThread.join();

//        MongoThread mongoThread = new MongoThread();
//        PostgresThread postgresThread = new PostgresThread();
//        mongoThread.start();
//        postgresThread.start();
//        mongoThread.join();
//        postgresThread.join();
    }

}
