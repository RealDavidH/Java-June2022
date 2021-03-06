package com.dhollinger.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.loginreg.models.LoginUser;
import com.dhollinger.loginreg.models.User;
import com.dhollinger.loginreg.servs.UserServ;

@Controller
public class UserController {
	private final UserServ serv;
	public UserController(UserServ serv) {
		this.serv = serv;
	}
	@RequestMapping("/")
	public String loadLoginReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}
	@RequestMapping("/register")
	public String checkReg(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "/login.jsp";
		} else {
			
			session.setAttribute("uuid", user.getId());
			System.out.println(user);
			return "redirect:/view"; //plus id of uuid
		}
	}
	@RequestMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/login.jsp";
		} 
			
		session.setAttribute("uuid", user.getId());
			return "redirect:/view"; //plus id of uuid
		}
	@GetMapping("/view")
	public String viewUser(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", serv.getOne((Long)session.getAttribute("uuid")));
		return "view.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		return "redirect:/";
	}
}
