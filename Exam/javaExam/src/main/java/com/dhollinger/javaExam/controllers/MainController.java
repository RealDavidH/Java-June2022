package com.dhollinger.javaExam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.javaExam.models.Name;
import com.dhollinger.javaExam.models.User;
import com.dhollinger.javaExam.services.NameServ;
import com.dhollinger.javaExam.services.UserServ;

@Controller
public class MainController {
	private final UserServ userServ;
	private final NameServ nameServ;
	
	public MainController(UserServ serv1, NameServ serv2) {
		this.nameServ = serv2;
		this.userServ = serv1;
	}
	
	@RequestMapping("/home")
	public String renderHome(Model model, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		model.addAttribute("sessionUser", user);
		model.addAttribute("allName", nameServ.getAll());
		return "index.jsp";
	}
	@PutMapping("/name/upvote/{id}")
	public String upvoteName(@PathVariable("id") Long idName, Model model, HttpSession session) {
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		Name name = nameServ.getOne(idName);
		name.getUserLiked().add(user);
		user.getNames().add(name);
		nameServ.saveOne(name);
		userServ.saveOne(user);
		
		
		return "redirect:/home";
	}
	
	@PutMapping("/name/unvote/{id}")
	public String unvoteName(@PathVariable("id") Long idName, Model model, HttpSession session) {
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		Name name = nameServ.getOne(idName);
		name.getUserLiked().remove(user);
		user.getNames().remove(name);
		nameServ.saveOne(name);
		userServ.saveOne(user);
		return "redirect:/home";
	}
	
	
	@PutMapping("/name/view/upvote/{id}")
	public String upvoteNameButOnViewPage(@PathVariable("id") Long idName, Model model, HttpSession session) {
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		Name name = nameServ.getOne(idName);
		name.getUserLiked().add(user);
		user.getNames().add(name);
		nameServ.saveOne(name);
		userServ.saveOne(user);
		
		
		return "redirect:/name/view/" + idName;
	}
}
