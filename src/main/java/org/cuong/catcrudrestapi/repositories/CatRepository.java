package org.cuong.catcrudrestapi.repositories;

import org.cuong.catcrudrestapi.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
    
}
