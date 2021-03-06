package com.dhollinger.cpunter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
			}
		return "index.jsp";
	}
	@RequestMapping("/count")
	public String counter(HttpSession session, Model model) {
		

			int currentcount = (Integer) session.getAttribute("count") + 1; 
			session.setAttribute("count", currentcount);
			model.addAttribute("counter", currentcount);
		
		return "index.jsp";
	}
}
