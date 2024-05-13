package com.malak.medecins.service;

import com.malak.medecins.entities.Role;
import com.malak.medecins.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
