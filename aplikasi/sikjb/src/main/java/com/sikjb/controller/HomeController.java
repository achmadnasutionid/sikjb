package com.sikjb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

<<<<<<< HEAD
    @GetMapping("/")
	 public String root() {
	 return "index";
	 }
	 @GetMapping("/user")
	 public String userIndex() {
	 return "user/index";
=======
	 @GetMapping("/")
	 public String index() {
	 	return "login";
>>>>>>> 969570d76703c2faac5e0c03cee68bdeabae38e3
	 }

	 @GetMapping("/login")
	 public String login() {
	 	return "login";
	 }

	 @GetMapping("/access-denied")
	 public String accessDenied() {
	 	return "/error/access-denied";
	 }

	 @RequestMapping("/home")
	 public String home() {
		return "home";
	}
}