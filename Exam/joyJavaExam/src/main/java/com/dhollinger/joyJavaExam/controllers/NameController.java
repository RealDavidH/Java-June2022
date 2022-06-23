package com.dhollinger.joyJavaExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.joyJavaExam.models.Name;
import com.dhollinger.joyJavaExam.services.NameServ;
import com.dhollinger.joyJavaExam.services.UserServ;

@Controller
public class NameController {
	private final UserServ userServ;
	private final NameServ nameServ;
	
	public NameController(UserServ serv1, NameServ serv2) {
		this.nameServ = serv2;
		this.userServ = serv1;
	}
	
	@RequestMapping("/name/add")
	public String renderForm(@ModelAttribute("oneName") Name name, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		return "createname.jsp";
	}
	
	@RequestMapping("/name/create")
	public String saveOne(@Valid @ModelAttribute("oneName") Name name, BindingResult result, HttpSession session) {
		name.setUser(userServ.getOne((Long) session.getAttribute("uuid")));
		nameServ.checkName(name, result);
		
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "createname.jsp";
		}
		
		return "redirect:/name/view/" + name.getId();
	}
	@RequestMapping("/name/view/{id}")
	public String renderViewName(@PathVariable("id") Long id, Model model, HttpSession session ) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("oneName", nameServ.getOne(id));
		return "viewname.jsp";
	}
	@RequestMapping("/name/edit/{id}")
	public String renderEditForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if(nameServ.getOne(id).getUser() != userServ.getOne((Long) session.getAttribute("uuid"))) {
			return "redirect:/home";
		};
		model.addAttribute("editName", nameServ.getOne(id));
		return "editname.jsp";
	}
	@PutMapping("/name/update/{id}")
	public String updateOne(@Valid @ModelAttribute("editName")Name name, BindingResult result, HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if(session.getAttribute("uuid") != nameServ.getOne(id).getUser().getId()) {
			return "redirect:/home";
		}
		
		if(result.hasErrors()) {
			return "editname.jsp";
		} else {
			name.setUser(userServ.getOne((Long) session.getAttribute("uuid")));
			nameServ.saveOne(name);
			
			return "redirect:/name/view/" + name.getId();
		}
		
	}
	@DeleteMapping("/name/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		nameServ.deleteOne(id);
		return "redirect:/home";
	}
}
