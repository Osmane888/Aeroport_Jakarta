package org.example.tb_java2024_demo_jakartaee_webapp.entities;

import jakarta.persistence.Entity;

@Entity
public class Owner extends Person {

    public Owner(){};

    public Owner(String firstname, String lastname, String telephone, Address address) {
        super(firstname, lastname, telephone, address);
    }
}
