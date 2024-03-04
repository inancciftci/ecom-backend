package com.example.eComBackend.service;

import com.example.eComBackend.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
}
