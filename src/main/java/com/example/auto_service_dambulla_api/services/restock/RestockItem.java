package com.example.auto_service_dambulla_api.services.restock;

import com.example.auto_service_dambulla_api.services.item.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "restock_items")
public class RestockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restock_id", nullable = false)
    private Restock restock;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restock getRestock() {
        return restock;
    }

    public void setRestock(Restock restock) {
        this.restock = restock;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
