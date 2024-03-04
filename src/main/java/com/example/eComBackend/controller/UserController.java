package com.example.eComBackend.controller;

import com.example.eComBackend.dto.UserResponse;
import com.example.eComBackend.entity.Role;
import com.example.eComBackend.entity.User;
import com.example.eComBackend.service.RoleService;
import com.example.eComBackend.service.StoreService;
import com.example.eComBackend.service.UserService;
import com.example.eComBackend.util.EntityToResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final StoreService storeService;

    @GetMapping("/{userId}")
    public UserResponse getById(@PathVariable Long userId){
        User u = userService.getUserById(userId);
        return EntityToResponse.userToRes(u);
    }

    @PostMapping("/{roleId}")
    public UserResponse createUser(@RequestBody User user, @PathVariable Long roleId) {
        if(roleId == 1 || roleId == 3) {
            Role foundRole = roleService.findById(roleId);
            foundRole.addUser(user);
            user.setRole(foundRole);
            User createdUser = userService.createUser(user);
            return EntityToResponse.userToRes(createdUser);
        }
        return null;
    }
}
