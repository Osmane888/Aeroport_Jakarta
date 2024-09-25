package org.example.tb_java2024_demo_jakartaee_webapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Pilot extends Person{

    @Column(unique=true,nullable = false,length = 50)
    private String plateNumber;

    public Pilot(){}

    public Pilot(String firstName, String lastName, String phoneNumber, Address address, String plateNumber) {
        super(firstName, lastName, phoneNumber, address);
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "Pilot{" +
                "plateNumber='" + plateNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(plateNumber, pilot.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plateNumber);
    }
}