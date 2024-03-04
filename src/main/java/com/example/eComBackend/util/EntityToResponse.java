package com.example.eComBackend.util;

import com.example.eComBackend.dto.ProductResponse;
import com.example.eComBackend.dto.UserResponse;
import com.example.eComBackend.entity.Product;
import com.example.eComBackend.entity.User;

public class EntityToResponse {
    public static ProductResponse prodToRes(Product p) {
        return new ProductResponse(
                p.getId(), p.getName(), p.getDescription(),
                p.getPrice(),p.getStock(),p.getStore().getId(),p.getCategory().getId(),
                p.getRating(), p.getSellCount(), p.getImages()
        );
    }

    public static UserResponse userToRes(User u){
        return new UserResponse(u.getId(), u.getName(), u.getEmail(), u.getRole().getName());
    }
}
