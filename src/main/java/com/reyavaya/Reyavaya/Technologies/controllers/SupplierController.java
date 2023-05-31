package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.Exception.ResourceNotFoundException;
import com.reyavaya.Reyavaya.Technologies.model.Supplier;
import com.reyavaya.Reyavaya.Technologies.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @PostMapping("/suppliers")
    public Supplier createSupplier(@RequestBody LinkedHashMap<String,String> supplier){
        Supplier supplierObj = new Supplier(supplier.get("name"),
                supplier.get("address"),
                supplier.get("contactNo"), supplier.get("email"));
        return supplierRepository.save(supplierObj);
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier with id "+id+" does not exist"));
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier supplierObj = supplierRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Supplier with id "+id+" does not exist"));
        supplierObj.setName(supplier.getName());
        supplierObj.setEmail(supplier.getEmail());
        supplierObj.setAddress(supplier.getAddress());
        supplierObj.setContactNo(supplier.getContactNo());

        Supplier updatedSupplier = supplierRepository.save(supplierObj);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Employee with id "+id+" doe not exist"));
        supplierRepository.delete(supplier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
