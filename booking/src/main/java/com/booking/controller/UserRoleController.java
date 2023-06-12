package com.booking.controller;

import com.booking.entities.UserRole;
import com.booking.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/")
    public UserRole addUserRole(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }

    @GetMapping("/{userId}")
    public List<UserRole> getUserRolesByUserId(@PathVariable Long userId) {
        return userRoleService.getUserRolesByUserId(userId);
    }
}


