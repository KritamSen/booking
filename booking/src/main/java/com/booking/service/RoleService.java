package com.booking.service;

import com.booking.entities.Role;

public interface RoleService {

    Role getRoleById(Long id);

    Role saveRole(Role role);

    Role updateRole(Long id, Role role);

    void deleteRole(Long id);
}
