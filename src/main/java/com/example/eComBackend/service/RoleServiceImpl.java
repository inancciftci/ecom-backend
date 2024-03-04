package com.example.eComBackend.service;

import com.example.eComBackend.entity.Role;
import com.example.eComBackend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElseThrow(() -> new RuntimeException("Please enter a number between 0-3"));
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
