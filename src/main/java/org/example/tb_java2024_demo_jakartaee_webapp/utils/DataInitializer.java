package org.example.tb_java2024_demo_jakartaee_webapp.utils;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.Plane;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.PlaneType;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneRepository;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.PlaneTypeRepository;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.impls.PlaneRepositoryImpl;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.impls.PlaneTypeRepositoryImpl;

@WebListener
public class DataInitializer implements ServletContextListener {

    private final PlaneRepository planeRepository;
    private final PlaneTypeRepository planeTypeRepository;

    public DataInitializer(){
        this.planeRepository = new PlaneRepositoryImpl();
        this.planeTypeRepository = new PlaneTypeRepositoryImpl();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce){
        Plane plane1 = new Plane(
                "123",
                5
        );
        Plane plane2 = new Plane(
                "456",
                5
        );
        Plane plane3 = new Plane(
                "789",
                5
        );

        planeRepository.save(plane1);
        planeRepository.save(plane2);
        planeRepository.save(plane3);

        PlaneType planeType1 = new PlaneType(
                "OOCNA",
                "Boeing",
                1000,
                5
        );
        PlaneType planeType2 = new PlaneType(
                "PTG",
                "Boeing",
                500,
                2
        );
        PlaneType planeType3 = new PlaneType(
                "trolilol",
                "Boeing",
                15000,
                200
        );

        planeTypeRepository.save(planeType1);
        planeTypeRepository.save(planeType2);
        planeTypeRepository.save(planeType3);
    }
}
