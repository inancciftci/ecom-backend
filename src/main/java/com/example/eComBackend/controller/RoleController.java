package com.example.eComBackend.controller;

import com.example.eComBackend.dto.RoleResponse;
import com.example.eComBackend.dto.RoleResponseWithUsers;
import com.example.eComBackend.entity.Role;
import com.example.eComBackend.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<RoleResponse> findAll(){
        List<RoleResponse> roleResponses = new ArrayList<>();
        for(Role role : roleService.findAll()) {
            roleResponses.add(new RoleResponse(role.getId() ,role.getName(), role.getCode()));
        }
        return roleResponses;
    }

    @GetMapping("/{roleId}")
    public RoleResponseWithUsers getRole(@PathVariable Long roleId){
        Role foundRole = roleService.findById(roleId);
        return new RoleResponseWithUsers(foundRole.getName(), foundRole.getCode(), foundRole.getUserEmails(foundRole.getUsers()));
    }
}
