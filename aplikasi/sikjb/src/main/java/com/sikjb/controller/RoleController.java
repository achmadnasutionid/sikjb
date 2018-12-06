package com.sikjb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.Role;
import com.sikjb.service.RoleService;



@Controller
public class RoleController {
	
	private RoleService roleService;
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/role")
	public String RoleList(Model model) {
		model.addAttribute("role", roleService.listRole());
		return "list/role";
	}
	
	@RequestMapping(value = "/role/create", method = RequestMethod.GET)
	public String showFormRole(Model model) {
		model.addAttribute("role", new Role());
		return "form/formRole";
	}	
	
	@RequestMapping(value = "/role/create", method = RequestMethod.POST)
	public String saveFormRole(Model model, Role role) {
			model.addAttribute("role", roleService.saveOrUpdate(role));
			return "redirect:/role";
	}
	
	@RequestMapping(value = "/role/edit/{roleId}", method = RequestMethod.GET)
	public String showFormEditRole(@PathVariable Long roleId, Model model) {
			model.addAttribute("role", roleService.getRoleById(roleId));
			return "form/formRole";
	}
	
	@RequestMapping(value = "/role/delete/{roleId}", method = RequestMethod.GET)
	public String deleteRole(@PathVariable Long roleId) {
			roleService.deleteRole(roleId);
			return "redirect:/role";
}
}