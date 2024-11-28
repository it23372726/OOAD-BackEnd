package com.example.auto_service_dambulla_api.services.supplier;

import com.example.auto_service_dambulla_api.services.supplier.dtos.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(SupplierDTO supplierDTO) {
        // Convert SupplierDTO to Supplier entity
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierDTO.getSupplierName());
        supplier.setContactInfo(supplierDTO.getContactInfo());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setStatus(supplierDTO.getStatus());
        // Initialize empty lists for items and restocks
        supplier.setItems(new ArrayList<>());
        supplier.setRestocks(new ArrayList<>());

        // Save the Supplier entity
        return supplierRepository.save(supplier);
    }


    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public void deleteSupplierById(Long id){
        supplierRepository.deleteById(id);
    }
}
