package com.example.auto_service_dambulla_api.services.item.dtos;

import com.example.auto_service_dambulla_api.services.item.Item;
import jakarta.persistence.*;

public class ItemDTO {


    private Long itemId;

    @Enumerated(EnumType.STRING)
    private Item.ItemType itemType;

    private String itemName;

    private String description;

    private Integer quantityInStock;

    private Double price;

    private Integer reorderThreshold;

    private Long supplierId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Item.ItemType getItemType() {
        return itemType;
    }

    public void setItemType(Item.ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}