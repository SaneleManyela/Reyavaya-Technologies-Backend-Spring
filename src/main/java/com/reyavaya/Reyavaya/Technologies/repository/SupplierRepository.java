package com.reyavaya.Reyavaya.Technologies.repository;

import com.reyavaya.Reyavaya.Technologies.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
