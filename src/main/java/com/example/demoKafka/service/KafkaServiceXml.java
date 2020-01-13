package com.example.demoKafka.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public interface KafkaServiceXml {
    public void read() throws ParserConfigurationException,
            SAXException, IOException, ParseException;
}
