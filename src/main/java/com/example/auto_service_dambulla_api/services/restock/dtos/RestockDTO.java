package com.example.auto_service_dambulla_api.services.restock.dtos;

import java.time.LocalDate;
import java.util.List;

public class RestockDTO {
    private Long orderId;

    private String instruction;

    private Boolean status;

    private List<RestockItemType> itemTypes;

    private Long supplierId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<RestockItemType> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<RestockItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}


