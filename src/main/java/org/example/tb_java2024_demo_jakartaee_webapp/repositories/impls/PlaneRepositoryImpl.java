package org.example.tb_java2024_demo_jakartaee_webapp.repositories.impls;

import jakarta.enterprise.context.SessionScoped;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.Plane;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneRepository;

import java.io.Serializable;

@SessionScoped
public class PlaneRepositoryImpl extends BaseRepositoryImpl<Plane,Long> implements PlaneRepository, Serializable {

    public PlaneRepositoryImpl(){
        super(Plane.class);
    }
}