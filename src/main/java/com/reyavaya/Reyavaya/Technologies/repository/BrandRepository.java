package com.reyavaya.Reyavaya.Technologies.repository;

import com.reyavaya.Reyavaya.Technologies.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    public Brand findByName(String name);
}
