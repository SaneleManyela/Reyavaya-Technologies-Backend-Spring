package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.model.Sale;
import com.reyavaya.Reyavaya.Technologies.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @PostMapping("/sales")
    public Sale createSale(@RequestBody LinkedHashMap<String, String> sale) {
        Sale saleObj = new Sale(Long.parseLong(sale.get("product")),
                Long.parseLong(sale.get("supplier")),Integer.parseInt(sale.get("sold_Qty")),
                Double.parseDouble(sale.get("sellingPrice")), Double.parseDouble(sale.get("saleTotal")),
                sale.get("saleDate"));
        return saleRepository.save(saleObj);
    }
}
