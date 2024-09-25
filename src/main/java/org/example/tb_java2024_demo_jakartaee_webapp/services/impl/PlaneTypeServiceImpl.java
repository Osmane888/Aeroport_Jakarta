package org.example.tb_java2024_demo_jakartaee_webapp.services.impl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.PlaneType;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneTypeRepository;
import org.example.tb_java2024_demo_jakartaee_webapp.services.PlaneTypeServices;

import java.io.Serializable;
import java.util.List;

@SessionScoped
public class PlaneTypeServiceImpl implements PlaneTypeServices, Serializable {

    @Inject
    private PlaneTypeRepository planeTypeRepository;

    public PlaneTypeServiceImpl(){}

    @Override
    public List<PlaneType> getAll(){
        return planeTypeRepository.findAll();
    }
}
