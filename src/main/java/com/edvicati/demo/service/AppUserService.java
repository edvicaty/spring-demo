package com.edvicati.demo.service;

import com.edvicati.demo.domain.AppUser;
import com.edvicati.demo.domain.Role;
import com.edvicati.demo.domain.RoleEnum;

import java.util.List;

// In this case, no RoleService will be created. All the Role logic will be implemented through the AppUser service
public interface AppUserService {
    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, RoleEnum roleName);

    AppUser getUserByUsername(String username);

    // TODO: Is good practice to return a paginated result
    List<AppUser> getUsers();

}
