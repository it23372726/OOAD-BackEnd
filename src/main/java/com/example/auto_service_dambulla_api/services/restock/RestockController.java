package com.example.auto_service_dambulla_api.services.restock;

import com.example.auto_service_dambulla_api.services.restock.dtos.RestockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restocking-orders")
public class RestockController {
    @Autowired
    private RestockService restockService;

    @PostMapping
    public ResponseEntity<Restock> createRestockingOrder(@RequestBody RestockDTO order) {
        return new ResponseEntity<>(restockService.createRestockingOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Restock>> getAllRestockingOrders() {
        return new ResponseEntity<>(restockService.getAllOrders(), HttpStatus.OK);
    }
}
