package com.example.auto_service_dambulla_api.services.transaction.dtos;

import java.time.LocalDate;
import java.util.List;

public class TransactionDTO {
    private Long transactionId;
    private String customerName;
    private Double cost;
    private Boolean status;
    private List<TransactionItemType> transactionItemTypes;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<TransactionItemType> getTransactionItemTypes() {
        return transactionItemTypes;
    }

    public void setTransactionItemTypes(List<TransactionItemType> transactionItemTypes) {
        this.transactionItemTypes = transactionItemTypes;
    }
}
