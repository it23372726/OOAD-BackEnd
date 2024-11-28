package com.example.auto_service_dambulla_api.services.supplier;

import com.example.auto_service_dambulla_api.services.supplier.dtos.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody SupplierDTO supplier) {
        return new ResponseEntity<>(supplierService.addSupplier(supplier), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return new ResponseEntity<>(supplierService.getAllSuppliers(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplierById(@PathVariable Long id){
        supplierService.deleteSupplierById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
