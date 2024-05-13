package com.malak.medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malak.medecins.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
