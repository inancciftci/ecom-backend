package com.example.eComBackend.repository;

import com.example.eComBackend.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
