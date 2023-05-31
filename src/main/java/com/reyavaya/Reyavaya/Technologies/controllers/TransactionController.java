package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.model.Transaction;
import com.reyavaya.Reyavaya.Technologies.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody LinkedHashMap<String, String> transaction){
        Transaction transactionObj = new Transaction(Long.parseLong(transaction.get("employee")),
                Long.parseLong(transaction.get("sale")), transaction.get("transactionDate"));
        return transactionRepository.save(transactionObj);
    }
}
