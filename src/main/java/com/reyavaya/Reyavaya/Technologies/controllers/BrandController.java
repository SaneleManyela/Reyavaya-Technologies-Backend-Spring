package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.Exception.ResourceNotFoundException;
import com.reyavaya.Reyavaya.Technologies.model.Brand;
import com.reyavaya.Reyavaya.Technologies.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @PostMapping("/findBrand")
    public ResponseEntity<Brand> findBrand(@RequestBody LinkedHashMap<String, String> brand) {
        Brand brandObj = brandRepository.findByName(brand.get("name"));
        return ResponseEntity.ok(brandObj);
    }

    @PostMapping("/brand")
    public Brand createBrand(@RequestBody LinkedHashMap<String, String> brand) {
        Brand brandObj = new Brand(brand.get("name"), brand.get("phasedOut"));
        return brandRepository.save(brandObj);
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getProductById(@PathVariable Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Brand with id "+id+" does not exist"
        ));
        return ResponseEntity.ok(brand);
    }

    @PutMapping("/brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        Brand brandObj = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Brand with id "+id+" does not exist"
        ));
        brandObj.setName(brand.getName());
        brandObj.setPhasedOut(brand.getPhasedOut());

        Brand updatedBrand = brandRepository.save(brandObj);
        return ResponseEntity.ok(updatedBrand);
    }
}
