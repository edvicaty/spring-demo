package com.edvicati.demo.service;

import com.edvicati.demo.domain.AppUser;
import com.edvicati.demo.domain.Role;
import com.edvicati.demo.repository.AppUserRepository;
import com.edvicati.demo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving user {} to the database", user.getName());
        return appUserRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Saving Role {} to User {}", role.getName(), user.getName());
        // By using the @Transactional annotation, the Role entity will be persisted without explicitly saving it
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        log.info("Fetching user {}", username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return appUserRepository.findAll();
    }
}
