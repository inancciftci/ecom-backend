package com.example.eComBackend.service;

import com.example.eComBackend.entity.Store;

public interface StoreService {
    Store createStore(Store store);
    Store getStoreById(Long id);
}
