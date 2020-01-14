package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Employee;
import com.example.demoKafka.service.KafkaSerializer;
import com.example.demoKafka.service.KafkaServiceXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class KafkaServiceXmlImpl implements KafkaServiceXml {

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate<String,byte[]> kafkaTemplate;
    @Autowired
    KafkaSerializer kafkaSerializer;

    public void read() throws ParserConfigurationException,
            SAXException, IOException, ParseException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("/Users/vaidyavishal/Downloads/demoKafka/src/employee.xml"));

        NodeList nodeList = document.getDocumentElement().getChildNodes();


        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                String firstname = elem.getElementsByTagName("firstName")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String lastname = elem.getElementsByTagName("lastName").item(0)
                        .getChildNodes().item(0).getNodeValue();

                String experience = elem.getElementsByTagName("experience")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String dateOfBirth = elem.getElementsByTagName("dateOfBirth")
                        .item(0).getChildNodes().item(0).getNodeValue();

                Employee emp = new Employee();
                emp.setFirstName(firstname);
                emp.setLastName(lastname);
                emp.setExperience(experience);
                emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth));

                this.kafkaTemplate.send(TOPIC,kafkaSerializer.serialize(TOPIC,emp));

            }
        }
    }

}
