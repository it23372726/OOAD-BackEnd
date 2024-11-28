package com.example.auto_service_dambulla_api.services.restock;

import com.example.auto_service_dambulla_api.services.item.Item;
import com.example.auto_service_dambulla_api.services.item.ItemService;
import com.example.auto_service_dambulla_api.services.restock.dtos.RestockDTO;
import com.example.auto_service_dambulla_api.services.restock.dtos.RestockItemType;
import com.example.auto_service_dambulla_api.services.supplier.Supplier;
import com.example.auto_service_dambulla_api.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RestockService {
    @Autowired
    private RestockRepository restockRepository;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private RestockItemRepository restockItemRepository;
    @Autowired
    private ItemService itemService;

    public Restock createRestockingOrder(RestockDTO restockDTO) {
        // Validate the DTO
        validateRestockDTO(restockDTO);

        // Fetch the supplier
        Supplier supplier = supplierService.getSupplierById(restockDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("No such supplier: " + restockDTO.getSupplierId()));

        // Create the Restock entity
        Restock restock = new Restock();
        restock.setInstruction(restockDTO.getInstruction());
        restock.setOrderDate(LocalDate.now());
        restock.setSupplier(supplier);

        // Save the Restock entity
        Restock savedRestock = restockRepository.save(restock);

        // Create and save RestockItems
        List<RestockItem> restockItems = restockDTO.getItemTypes().stream()
                .map(itemType -> createRestockItem(savedRestock, itemType))
                .toList();
        restockItemRepository.saveAll(restockItems);

        return savedRestock;
    }

    private void validateRestockDTO(RestockDTO restockDTO) {
        if (restockDTO == null || restockDTO.getSupplierId() == null) {
            throw new IllegalArgumentException("RestockDTO or Supplier ID cannot be null");
        }

        if (restockDTO.getItemTypes() == null || restockDTO.getItemTypes().isEmpty()) {
            throw new IllegalArgumentException("Restock must include at least one item");
        }
    }

    private RestockItem createRestockItem(Restock restock, RestockItemType restockItemType) {
        // Fetch the item
        Item item = itemService.getItemById(restockItemType.getItemId())
                .orElseThrow(() -> new RuntimeException("No such item: " + restockItemType.getItemId()));

        // Create the RestockItem
        RestockItem restockItem = new RestockItem();
        restockItem.setRestock(restock);
        restockItem.setItem(item);
        restockItem.setAmount(restockItemType.getAmount());

        return restockItem;
    }

    public List<Restock> getAllOrders() {
        return restockRepository.findAll();
    }
}

