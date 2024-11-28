package com.example.auto_service_dambulla_api.services.item;

import com.example.auto_service_dambulla_api.services.item.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody ItemDTO item) {
        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{itemId}") // Accept itemId as path variable
    public ResponseEntity<Item> deleteItem(@PathVariable Long itemId) {
        Item deletedItem = itemService.deleteItem(itemId);

        if (deletedItem == null) {
            // Return 404 if the item was not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return 200 if the item was successfully deleted
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/low-stock")
    public ResponseEntity<List<Item>> getLowStockItems() {
        return new ResponseEntity<>(itemService.getLowStockItems(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @GetMapping("/fuel")
    public ResponseEntity<List<Item>> getAllFuelItems(){
        return ResponseEntity.ok(itemService.getAllItems(Item.ItemType.FUEL));
    }

    @CrossOrigin
    @GetMapping("/lsp")
    public ResponseEntity<List<Item>> getAllLSPItems(){
        return ResponseEntity.ok(itemService.getAllItems(Item.ItemType.LSP));
    }
}

