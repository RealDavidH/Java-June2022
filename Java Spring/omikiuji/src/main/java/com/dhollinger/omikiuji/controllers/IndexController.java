package com.dhollinger.omikiuji.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("")
	public String renderIndex() {
		return "index.jsp";
	}
	@RequestMapping("/process")
	public String processInfo ( @RequestParam Map <String, String> person, HttpSession session) {
		session.setAttribute("info", person);
		return "redirect:/show";
	}
	@RequestMapping("/show")
	public String show(Model model, HttpSession session) {
		model.addAttribute(session.getAttribute("info"));
		return "show.jsp";
	}
}

