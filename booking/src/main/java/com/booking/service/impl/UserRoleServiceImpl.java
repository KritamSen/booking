package com.booking.service.impl;

import com.booking.entities.UserRole;
import com.booking.repository.UserRoleRepository;
import com.booking.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole addUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getUserRolesByUserId(Long userId) {
        return userRoleRepository.findByUser_Id(userId);
    }
}

