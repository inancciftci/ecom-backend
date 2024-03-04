package com.example.eComBackend.dto;

import com.example.eComBackend.entity.Store;

public record UserResponseWithStore(UserResponse userResponse, StoreResponse storeResponse) {
}
