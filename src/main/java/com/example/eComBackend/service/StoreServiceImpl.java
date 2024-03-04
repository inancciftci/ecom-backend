package com.example.eComBackend.service;

import com.example.eComBackend.entity.Store;
import com.example.eComBackend.entity.User;
import com.example.eComBackend.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store with given id not found"));
    }
}
