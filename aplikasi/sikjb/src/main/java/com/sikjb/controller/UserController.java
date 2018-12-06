package com.sikjb.controller;


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
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user")
	public String UserList(Model model) {
		model.addAttribute("user", userService.listUser());
		return "list/user";
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String showFormUser(Model model) {
		model.addAttribute("user", new User());
		return "form/formUser";
	}	
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String saveFormUser(Model model, User user) {
			model.addAttribute("user", userService.saveOrUpdate(user));
			return "redirect:/user";
	}
	
	@RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.GET)
	public String showFormEditUser(@PathVariable Long userId, Model model) {
			model.addAttribute("user", userService.getUserById(userId));
			return "form/formUser";
	}
	
	@RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.GET)
	public String deleteuser(@PathVariable Long userId) {
			userService.deleteUser(userId);
			return "redirect:/user";
}
}