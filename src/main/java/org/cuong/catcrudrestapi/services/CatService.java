package org.cuong.catcrudrestapi.services;

import java.util.List;
import java.util.Optional;

import org.cuong.catcrudrestapi.entities.Cat;

public interface CatService {
    List<Cat> getAllCats();
    Optional<Cat> getCatById(long id);
    Cat saveCat(Cat cat);
    void deleteCatById(long id);
}
