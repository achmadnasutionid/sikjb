package com.sikjb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	 @GetMapping("/")
	 public String index() {
	 	return "login";
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