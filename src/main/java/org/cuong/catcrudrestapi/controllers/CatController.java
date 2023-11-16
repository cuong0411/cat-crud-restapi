package org.cuong.catcrudrestapi.controllers;

import java.util.List;
import org.cuong.catcrudrestapi.entities.Cat;
import org.cuong.catcrudrestapi.services.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cats")
public class CatController {
    
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCatById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(catService.getCatById(id));
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(catService.saveCat(cat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCat(@PathVariable long id, @RequestBody Cat cat) {
        catService.getCatById(id);
        cat.setId(id);
        return ResponseEntity.ok(catService.saveCat(cat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCatById(@PathVariable long id) {
        catService.getCatById(id);
        catService.deleteCatById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete successfully cat with id " + id);
    }
    
}
