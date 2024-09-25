package org.example.tb_java2024_demo_jakartaee_webapp.services.impl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.Plane;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneRepository;
import org.example.tb_java2024_demo_jakartaee_webapp.services.PlaneServices;

import java.io.Serializable;
import java.util.List;

@SessionScoped
public class PlaneServiceImpl implements PlaneServices, Serializable {

    @Inject
    private PlaneRepository planeRepository;

    public PlaneServiceImpl() {}

    @Override
    public List<Plane> getAll() {
        return planeRepository.findAll();
    }
}
