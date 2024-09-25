package org.example.tb_java2024_demo_jakartaee_webapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.validator.constraints.Range;

import java.util.Objects;

@Entity
public class PlaneType extends BaseEntity<Long>{

    @Column(unique=true,nullable=false,length=100)
    private String name;
    @Column(nullable = false,length = 150)
    private String manufacturer;
    @Column(nullable = false)
    @Range(min = 0)
    private double power;
    @Column(nullable = false)
    @Range(min = 0)
    private int seatCount;

    public PlaneType(){}

    public PlaneType(String name, String manufacturer, double power, int seatCount) {
        this();
        this.name = name;
        this.manufacturer = manufacturer;
        this.power = power;
        this.seatCount = seatCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "PlaneType{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", power=" + power +
                ", seatCount=" + seatCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaneType planeType = (PlaneType) o;
        return Double.compare(power, planeType.power) == 0 && seatCount == planeType.seatCount && Objects.equals(name, planeType.name) && Objects.equals(manufacturer, planeType.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, manufacturer, power, seatCount);
    }
}