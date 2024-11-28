package com.example.auto_service_dambulla_api.services.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByQuantityInStockLessThan(Integer reorderThreshold);
    List<Item> findAllByItemType(Item.ItemType itemType);
}
