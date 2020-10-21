package com.rupesh.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rupesh.app.entities.User;
import com.rupesh.app.password.encription.PasswordEncriptor;
import com.rupesh.app.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncriptor passwordEncriptor;

	@GetMapping("/user-form")
	public String showUserRegForm(Model model) {
		model.addAttribute("user",new User());
		return "user-reg";
	}
	
	@PostMapping("/reg-user")
	public String createUser(@ModelAttribute("user") User user) {
		user.setPassword(passwordEncriptor.encriptPassword(user.getPassword()));
		userService.createUser(user);
		return "redirect:/logout";
	}
	
}
