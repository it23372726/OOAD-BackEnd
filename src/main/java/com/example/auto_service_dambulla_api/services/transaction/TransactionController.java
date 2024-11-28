package com.example.auto_service_dambulla_api.services.transaction;

import com.example.auto_service_dambulla_api.services.transaction.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @CrossOrigin
    @PostMapping("/doneTransaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionDTO transaction) {
        return new ResponseEntity<>(transactionService.addTransaction(transaction), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id)
                .map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @CrossOrigin
    @GetMapping("/status")
    public ResponseEntity<List<Transaction>> getTransactionsByStatus(@RequestParam Boolean status) {
        return new ResponseEntity<>(transactionService.getTransactionsByStatus(status), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}

