package com.sikjb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

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