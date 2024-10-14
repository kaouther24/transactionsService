package com.bank.transaction.controller;

import com.bank.transaction.service.TransactionService;
import com.bank.transaction.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Application is healthy");
    }

    @GetMapping("/byId/{transactionUuid}")
    public Optional<Transaction> getTransactionByUuid(@PathVariable String transactionUuid) throws IOException {

        return transactionService.findTransaction(transactionUuid);
    }

    @GetMapping("/byAccountUuid/{accountUuid}")
    public List<Transaction> getTransactionsByAccountUuid(@PathVariable String accountUuid) throws IOException {

        return transactionService.findAllTransactionsByAccount(accountUuid);
    }

    @PostMapping("/new")
    @ResponseBody
    public List<Transaction> createNewTransaction(@RequestBody Transaction newTransaction) throws IOException {

        newTransaction.setUuid(UUID.randomUUID().toString());
        return transactionService.addNewTransaction(newTransaction);
    }

}
