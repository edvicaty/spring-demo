package com.edvicati.demo;

import com.edvicati.demo.domain.AppUser;
import com.edvicati.demo.domain.Role;
import com.edvicati.demo.domain.RoleEnum;
import com.edvicati.demo.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // The run method will allow to create new data when the application first starts
    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {

            appUserService.saveRole(new Role(null, RoleEnum.ROLE_USER));
            appUserService.saveRole(new Role(null, RoleEnum.ROLE_MANAGER));
            appUserService.saveRole(new Role(null, RoleEnum.ROLE_ADMIN));
            appUserService.saveRole(new Role(null, RoleEnum.ROLE_SUPER_ADMIN));

            appUserService.saveUser(new AppUser(null, "Edgar Villavicencio", "edvicati", "1234", new HashSet<>()));
            appUserService.saveUser(new AppUser(null, "Ana Sanchez", "ana_santet", "4321", new HashSet<>()));

            appUserService.addRoleToUser("edvicati", RoleEnum.ROLE_USER);
            appUserService.addRoleToUser("ana_santet", RoleEnum.ROLE_ADMIN);
        };
    }

}
