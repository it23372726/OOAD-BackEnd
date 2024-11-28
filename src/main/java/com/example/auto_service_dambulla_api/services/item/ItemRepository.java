package com.example.auto_service_dambulla_api.services.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByQuantityInStockLessThan(Integer reorderThreshold);
    @Query("SELECT i FROM Item i WHERE i.itemType = :itemType")
    List<Item> findAllByItemType(@Param("itemType") Item.ItemType itemType);

    @Query("SELECT i FROM Item i where i.itemId = :itemId")
    Item findItemId(@Param("itemId") Long itemId);

}
