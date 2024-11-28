package com.example.auto_service_dambulla_api.services.restock;

import com.example.auto_service_dambulla_api.services.item.Item;
import com.example.auto_service_dambulla_api.services.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "restocks")
public class Restock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate orderDate;

    private String instruction;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @JsonManagedReference
    @OneToMany(mappedBy = "restock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestockItem> restockItems;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public List<RestockItem> getRestockItems() {
        return restockItems;
    }

    public void setRestockItems(List<RestockItem> restockItems) {
        this.restockItems = restockItems;
    }
}

