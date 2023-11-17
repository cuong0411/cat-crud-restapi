package org.cuong.catcrudrestapi.services;

import java.util.List;
import java.util.Optional;

import org.cuong.catcrudrestapi.entities.Cat;
import org.cuong.catcrudrestapi.exception.CatNotFoundException;
import org.cuong.catcrudrestapi.repositories.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService{
    
    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Optional<Cat> getCatById(long id) {
        Optional<Cat> cat = catRepository.findById(id);
        if (!cat.isPresent()) {
            throw new CatNotFoundException("Cat with id " + id + " not found.");
        }
        return cat;
    }

    @Override
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteCatById(long id) {
        catRepository.deleteById(id);
    }
}
