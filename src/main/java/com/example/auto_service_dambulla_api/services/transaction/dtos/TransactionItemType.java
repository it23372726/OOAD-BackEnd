package com.example.auto_service_dambulla_api.services.transaction.dtos;

public class TransactionItemType {
    private Long id;
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
