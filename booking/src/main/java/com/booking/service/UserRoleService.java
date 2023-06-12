package com.booking.service;

import com.booking.entities.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole addUserRole(UserRole userRole);
    List<UserRole> getUserRolesByUserId(Long userId);
}


