package org.cuong.catcrudrestapi.repositories;

import java.util.List;
import java.util.Optional;

import org.cuong.catcrudrestapi.entities.Cat;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class CatDao {

    private final EntityManager entityManager;

    public CatDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Cat> findAll() {
        return entityManager
            .createQuery("from Cat", Cat.class)
            .getResultList();    
    }

    public Optional<Cat> findById(long id) {
        var cat = entityManager.find(Cat.class, id);
        return Optional.ofNullable(cat);
    }

    public Cat save(Cat cat) {
        return entityManager.merge(cat);
    }

    public void deleteById(long id) {
        var cat = entityManager.find(Cat.class, id);
        entityManager.remove(cat);
    }
}
