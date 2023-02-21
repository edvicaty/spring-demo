package com.edvicati.demo.service;

import com.edvicati.demo.domain.AppUser;
import com.edvicati.demo.domain.Role;

import java.util.List;

// In this case, no RoleService will be created. All the Role logic will be implemented through the AppUser service
// save user, save role, add role to user by names, get user by username, get all users
public interface AppUserService {
    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUserByUsername(String username);

    // Is good practice to return a paginated result
    List<AppUser> getUsers();

}
