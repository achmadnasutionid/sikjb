package com.sikjb.controller;


import com.sikjb.model.Role;
import com.sikjb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sikjb.model.User;
import com.sikjb.service.UserService;

@Controller
public class UserController {

	private RoleService roleService;

	private UserService userService;

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user")
	public String UserList(Model usermodel, Model rolemodel) {
		usermodel.addAttribute("user", userService.listUser());
		rolemodel.addAttribute("role", userService.listUser());
		return "list/user";
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String showFormUser(Model usermodel, Model rolemodel) {
		usermodel.addAttribute("user", new User());
		rolemodel.addAttribute("role", new Role());
		return "form/formUser";
	}	
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String saveFormUser(Model usermodel, Model rolemodel, User user, Role role) {
		usermodel.addAttribute("user", userService.saveOrUpdate(user));
		rolemodel.addAttribute("role", roleService.saveOrUpdate(role));
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/user/edit/{username}", method = RequestMethod.GET)
	public String showFormEditUser(@PathVariable String username, Model usermodel, Model rolemodel) {
		usermodel.addAttribute("user", userService.getUserByUsername(username));
		rolemodel.addAttribute("role", roleService.getRoleByUsername(username));
		return "form/formUser";
	}
	
	@RequestMapping(value = "/user/delete/{username}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
		roleService.deleteRole(username);
		return "redirect:/user";
}
}