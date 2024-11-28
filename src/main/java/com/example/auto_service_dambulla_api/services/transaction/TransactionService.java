package com.example.auto_service_dambulla_api.services.transaction;

import com.example.auto_service_dambulla_api.services.item.Item;
import com.example.auto_service_dambulla_api.services.item.ItemService;
import com.example.auto_service_dambulla_api.services.restock.RestockItem;
import com.example.auto_service_dambulla_api.services.transaction.dtos.TransactionDTO;
import com.example.auto_service_dambulla_api.services.transaction.dtos.TransactionItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactonItemRepository transactonItemRepository;
    @Autowired
    private ItemService itemService;
    // Add a new transaction
    public Transaction addTransaction(TransactionDTO transactionDTO) {


        // Create the Restock entity
        Transaction transaction = new Transaction();
        transaction.setCustomerName(transactionDTO.getCustomerName());
        transaction.setCost(transactionDTO.getCost());
        transaction.setTransactionDate(LocalDate.now());

        // Save the Restock entity
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Create and save RestockItems
        List<TransactionItem> transItems = transactionDTO.getTransactionItemTypes().stream()
                .map(itemType -> createTransItem(savedTransaction, itemType))
                .toList();
        transactonItemRepository.saveAll(transItems);

        return savedTransaction;
    }



    private TransactionItem createTransItem(Transaction transaction, TransactionItemType transactionItemType) {
        // Fetch the item
        Item item = itemService.getItemById(transactionItemType.getId())
                .orElseThrow(() -> new RuntimeException("No such item: " + transactionItemType.getId()));

        // Create the RestockItem
        TransactionItem transactionItem = new TransactionItem();
       transactionItem.setTransaction(transaction);
        transactionItem.setItem(item);
        transactionItem.setAmount(transactionItemType.getAmount());

        return transactionItem;
    }
    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get a transaction by ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Get transactions by status
    public List<Transaction> getTransactionsByStatus(Boolean status) {
        return transactionRepository.findByStatus(status);
    }

    // Delete a transaction by ID
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
