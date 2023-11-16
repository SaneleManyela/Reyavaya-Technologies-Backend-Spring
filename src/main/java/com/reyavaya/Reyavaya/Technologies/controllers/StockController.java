package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.Exception.ResourceNotFoundException;
import com.reyavaya.Reyavaya.Technologies.model.Stock;
import com.reyavaya.Reyavaya.Technologies.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stock")
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @PostMapping("/stock")
    private Stock createStock(@RequestBody LinkedHashMap<String, String> stock) {
        Stock stockObj = new Stock(Long.parseLong(stock.get("product")),
                Integer.parseInt(stock.get("qty")));
        return stockRepository.save(stockObj);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock with id "+id+" does not exist"));
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
       Stock stockObj = stockRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException(
                       "Stock with id "+id+" does not exist"));
       stockObj.setQty(stock.getQty());
       Stock updatedStock = stockRepository.save(stockObj);
       return ResponseEntity.ok(updatedStock);
    }

}
