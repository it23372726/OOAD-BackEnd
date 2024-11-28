package com.example.auto_service_dambulla_api.services.item;

import com.example.auto_service_dambulla_api.services.item.dtos.ItemDTO;
import com.example.auto_service_dambulla_api.services.supplier.Supplier;
import com.example.auto_service_dambulla_api.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SupplierService supplierService;

    public Item addItem(ItemDTO item) {
        Optional<Supplier> supplier = supplierService.getSupplierById(item.getSupplierId());

        if (supplier.isEmpty()){
            throw new RuntimeException("No such supplier: "+item.getSupplierId());
        }

        Item newItem = new Item();
        newItem.setItemName(item.getItemName());
        newItem.setItemType(item.getItemType());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        newItem.setQuantityInStock(item.getQuantityInStock());
        newItem.setSupplier(supplier.get());
        newItem.setReorderThreshold(item.getReorderThreshold());

        return itemRepository.save(newItem);
    }
    public Item deleteItem(Long itemId) {
        // Find the item by itemId
        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if (optionalItem.isPresent()) {
            // If item exists, delete it
            Item deletedItem = optionalItem.get();
            itemRepository.deleteById(itemId);
            return deletedItem; // Return the deleted item details
        } else {
            // If item does not exist, return null
            return null;
        }
    }



    public List<Item> getLowStockItems() {
        return itemRepository.findAll().stream()
                .filter(item -> item.getQuantityInStock() < item.getReorderThreshold())
                .collect(Collectors.toList());
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems(Item.ItemType itemType){
        return itemRepository.findAllByItemType(itemType);
    }
}
