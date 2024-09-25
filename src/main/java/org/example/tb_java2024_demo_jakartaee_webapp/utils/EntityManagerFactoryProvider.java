package org.example.tb_java2024_demo_jakartaee_webapp.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME = "DemoJakartaAirport";

    public static synchronized EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    public static synchronized void closeEntityManagerFactory(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}
