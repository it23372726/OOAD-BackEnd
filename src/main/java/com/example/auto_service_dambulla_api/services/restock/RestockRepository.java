package com.example.auto_service_dambulla_api.services.restock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockRepository extends JpaRepository<Restock, Long> {
}
