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
    AppUserRepository appUserRepository;
    RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        // By using the @Transactional annotation, the Role entity will be persisted without explicitly saving it
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }
}
