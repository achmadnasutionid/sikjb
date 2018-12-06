package com.sikjb.service;

import java.util.List;

import com.sikjb.model.Role;


public interface RoleService {
	
	List<Role> listRole();
	
	Role saveOrUpdate(Role role);
	
	Role getRoleByUsername(String roleUsername);
	
	void deleteRole(String roleId);

}