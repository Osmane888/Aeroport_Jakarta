package org.example.tb_java2024_demo_jakartaee_webapp.repositories.impls;

import jakarta.enterprise.context.SessionScoped;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.PlaneType;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneTypeRepository;

import java.io.Serializable;

@SessionScoped
public class PlaneTypeRepositoryImpl extends BaseRepositoryImpl<PlaneType,Long> implements PlaneTypeRepository, Serializable {

    public PlaneTypeRepositoryImpl(){
        super(PlaneType.class);
    }
}