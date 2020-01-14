package com.example.demoKafka.thread;

import com.example.demoKafka.service.KafkaServiceXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

@Component
public class XmlThread extends Thread {
    @Autowired
    KafkaServiceXml kafkaServiceXml;
    public void run(){
        try {
            kafkaServiceXml.read();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
