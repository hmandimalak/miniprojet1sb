package com.malak.medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malak.medecins.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}