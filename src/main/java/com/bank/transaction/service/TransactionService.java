package com.bank.transaction.service;

import com.bank.transaction.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {
    // addNewTransaction findTransaction findALlTransactions

    private final ResourceLoader resourceLoader;
    private static List<Transaction> transactions;

    public TransactionService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<Transaction> getTransactions() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:Transactions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Transaction>>() {
        });
    }

    public Optional<Transaction> findTransaction(String transactionUuid) throws IOException {
        if (transactions == null) {
            transactions = getTransactions();
        }
        return transactions.stream().filter(transaction -> transaction.getUuid().equalsIgnoreCase(transactionUuid)).findFirst();
    }

    public List<Transaction> findAllTransactionsByAccount(String accountUuid) throws IOException {
        if (transactions == null) {
            transactions = getTransactions();
        }
        return transactions.stream().filter(transaction -> transaction.getAccountUuid().equalsIgnoreCase(accountUuid)).toList();
    }

    public List<Transaction> addNewTransaction(Transaction newTransaction) throws IOException {
        if (transactions == null) {
            transactions = getTransactions();
        }
        transactions.add(newTransaction);
        return transactions;
    }

}
