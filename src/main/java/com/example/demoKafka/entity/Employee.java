package com.example.demoKafka.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

import java.util.Date;

@Entity
@Document
public class Employee {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String experience;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
