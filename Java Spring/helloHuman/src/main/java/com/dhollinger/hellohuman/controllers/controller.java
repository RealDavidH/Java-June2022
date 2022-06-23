package com.dhollinger.hellohuman.controllers;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class controller {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Yo mama");
		return "helloWorld.jsp";
	}
		

}
