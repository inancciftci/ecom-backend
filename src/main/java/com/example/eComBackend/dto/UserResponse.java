package com.example.eComBackend.dto;

import com.example.eComBackend.entity.Role;

public record UserResponse(Long id,String name, String email, String role) {
}
