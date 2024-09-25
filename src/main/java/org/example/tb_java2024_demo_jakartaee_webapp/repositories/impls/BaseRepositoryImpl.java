package org.example.tb_java2024_demo_jakartaee_webapp.repositories.impls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.tb_java2024_demo_jakartaee_webapp.repositories.BaseRepository;
import org.example.tb_java2024_demo_jakartaee_webapp.utils.EntityManagerFactoryProvider;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Id;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<TEntity, TId> implements BaseRepository<TEntity, TId> {

    protected final EntityManagerFactory emf;
    private final Class<TEntity> entityClass;

    public BaseRepositoryImpl(Class<TEntity> entityClass) {
        this.entityClass = entityClass;
        this.emf = EntityManagerFactoryProvider.getEntityManagerFactory();
    }

    @Override
    public TEntity save(TEntity entity) {

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public Optional<TEntity> findById(TId id) {
        try (EntityManager em = emf.createEntityManager()) {
            TEntity entity = em.find(entityClass, id);
            return Optional.of(entity);
        }
    }

    @Override
    public List<TEntity> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                    .getResultList();
        }
    }

    @Override
    public void update(TEntity entity) {
        try (EntityManager em = emf.createEntityManager()) {
            TId id = null;
            Field[] fields = entityClass.getDeclaredFields();
            Field field = Arrays.stream(fields).
                    filter(f -> f.isAnnotationPresent(Id.class) || f.isAnnotationPresent(EmbeddedId.class))
                    .findFirst().orElseThrow();
            field.setAccessible(true);
            id = (TId) field.get(entity);

            em.getTransaction().begin();
            TEntity result = em.find(entityClass, id);
            if(entity == null){
                throw new RuntimeException("entity not found");
            }
            em.merge(entity);
            em.getTransaction().commit();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(TId id) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            TEntity entity = em.find(entityClass, id);
            if(entity == null){
                throw new RuntimeException("entity not found");
            }
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}
