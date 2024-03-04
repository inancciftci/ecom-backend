package com.example.eComBackend.controller;

import com.example.eComBackend.dto.StoreResponse;
import com.example.eComBackend.entity.Role;
import com.example.eComBackend.entity.Store;
import com.example.eComBackend.service.RoleService;
import com.example.eComBackend.service.StoreService;
import com.example.eComBackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {
    private final UserService userService;
    private final StoreService storeService;
    private final RoleService roleService;

    @PostMapping("/{roleId}")
    public StoreResponse save(@RequestBody Store store, @PathVariable Long roleId){
        if(roleId == 2) {
            Store createdStore = storeService.createStore(store);
            Role foundRole = roleService.findById(roleId);
            createdStore.getUser().setRole(foundRole);
            userService.createUser(createdStore.getUser());
            return new StoreResponse(createdStore.getStoreName(), createdStore.getPhoneNumber(), createdStore.getTaxId(), createdStore.getBankAccount(), createdStore.getUser().getId());
        }
       return null;
    }
}
