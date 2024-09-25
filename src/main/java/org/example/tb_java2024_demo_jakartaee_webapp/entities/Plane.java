package org.example.tb_java2024_demo_jakartaee_webapp.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import java.util.Objects;

@Entity
public class Plane extends BaseEntity<Long>{

    @Column(unique=true,nullable = false,length = 50)
    private String plateNumber;

    @Column(nullable = false)
    @Range(min = 0)
    private int flyCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private PlaneType planeType;

    public Plane(){}

    public Plane(String plateNumber, int flyCount) {
        this();
        this.plateNumber = plateNumber;
        this.flyCount = flyCount;
    }

    public Plane(String plateNumber, int flyCount, Owner owner, PlaneType planeType) {
        this(plateNumber, flyCount);
        this.owner = owner;
        this.planeType = planeType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getFlyCount() {
        return flyCount;
    }

    public void setFlyCount(int flyCount) {
        this.flyCount = flyCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "Plane{" +
                "plateNumber='" + plateNumber + '\'' +
                ", flyCount=" + flyCount +
                ", owner=" + owner +
                ", planeType=" + planeType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return flyCount == plane.flyCount && Objects.equals(plateNumber, plane.plateNumber) && Objects.equals(owner, plane.owner) && Objects.equals(planeType, plane.planeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plateNumber, flyCount, owner, planeType);
    }
}