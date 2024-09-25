package org.example.tb_java2024_demo_jakartaee_webapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Maintenance extends BaseEntity<Long>{

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime actualDate;

    @Column
    @Range(min = 0)
    private int duration;

    @ManyToOne(fetch = FetchType.EAGER)
    private Plane plane;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mechanic repairer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mechanic inspector;

    public Maintenance() {
        super();
    }

    public Maintenance(String description, LocalDateTime actualDate, int duration) {
        this();
        this.description = description;
        this.actualDate = actualDate;
        this.duration = duration;
    }

    public Maintenance(String description, LocalDateTime actualDate, int duration, Plane plane, Mechanic repairer, Mechanic inspector) {
        this(description, actualDate, duration);
        this.plane = plane;
        this.repairer = repairer;
        this.inspector = inspector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getActualDate() {
        return actualDate;
    }

    public void setActualDate(LocalDateTime actualDate) {
        this.actualDate = actualDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Mechanic getRepairer() {
        return repairer;
    }

    public void setRepairer(Mechanic repairer) {
        this.repairer = repairer;
    }

    public Mechanic getInspector() {
        return inspector;
    }

    public void setInspector(Mechanic inspector) {
        this.inspector = inspector;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                "Maintenance{" +
                "description='" + description + '\'' +
                ", actualDate=" + actualDate +
                ", duration=" + duration +
                ", plane=" + plane +
                ", repairer=" + repairer +
                ", inspector=" + inspector +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Maintenance that = (Maintenance) o;
        return duration == that.duration && Objects.equals(description, that.description) && Objects.equals(actualDate, that.actualDate) && Objects.equals(plane, that.plane) && Objects.equals(repairer, that.repairer) && Objects.equals(inspector, that.inspector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, actualDate, duration, plane, repairer, inspector);
    }
}
