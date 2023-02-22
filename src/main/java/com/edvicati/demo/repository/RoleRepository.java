package com.edvicati.demo.repository;

import com.edvicati.demo.domain.Role;
import com.edvicati.demo.domain.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleEnum name);
}
