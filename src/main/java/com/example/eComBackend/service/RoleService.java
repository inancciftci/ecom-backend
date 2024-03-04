package com.example.eComBackend.service;

import com.example.eComBackend.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role findById(Long id);
    void delete(Role role);
}
