package com.sikjb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/")
	 public String root() {
	 return "index";
	 }
	 @GetMapping("/user")
	 public String userIndex() {
	 return "user/index";
	 }
	 @GetMapping("/login")
	 public String login() {
	 return "login";
	 }
	 @GetMapping("/access-denied")
	 public String accessDenied() {
	 return "/error/access-denied";
	 }

	 @GetMapping("/home")
	 public String home() {
	 return "home";
	 }

}