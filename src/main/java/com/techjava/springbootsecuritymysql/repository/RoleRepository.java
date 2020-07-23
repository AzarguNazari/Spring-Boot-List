package com.techjava.springbootsecuritymysql.repository;

import com.techjava.springbootsecuritymysql.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

