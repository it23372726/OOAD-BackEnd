package com.example.auto_service_dambulla_api.services.restock.dtos;

public class RestockItemType{
    private Long itemId;
    private Integer amount;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}