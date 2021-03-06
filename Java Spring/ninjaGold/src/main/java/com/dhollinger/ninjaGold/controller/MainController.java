package com.dhollinger.ninjaGold.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Random random = new Random();
	@RequestMapping("/")
	public String renderIndex(HttpSession session, Model model) {
		System.out.println(session.isNew());
		if(session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("messages", new ArrayList<String>());
			System.out.println(session.getAttribute("messages"));
		} 
		System.out.println(session.getAttribute("messages"));
		model.addAttribute("message", session.getAttribute("messages"));
		model.addAttribute("gold", session.getAttribute("gold"));
		System.out.println(model);
		return "index.jsp";
	}
	@RequestMapping("/{name}")
	public String processgold(HttpSession session, @PathVariable("name") String name) {
		int gold = (Integer) session.getAttribute("gold");
		ArrayList<String> currentmessages = (ArrayList<String>) session.getAttribute("messages");
		System.out.println(name);
		if(name.equals("farm")) {
			int randnum = random.nextInt(20 - 10 + 1) + 10;
			gold += randnum;
			currentmessages.add("You got " + randnum + "at the farm");
			session.setAttribute("messages", currentmessages);
			session.setAttribute("gold", gold);
			
		} else if(name.equals("cave")) {
			int randnum = random.nextInt(10 - 5 + 1) + 5;
			gold += randnum;
			currentmessages.add("You got " + randnum + "at the cave");
			session.setAttribute("messages", currentmessages);
			session.setAttribute("gold", gold);
		} else if(name.equals("house")) {
			int randnum = random.nextInt(5 - 2 + 1) + 2;
			gold += randnum;
			currentmessages.add("You got " + randnum + "at the house");
			session.setAttribute("messages", currentmessages);
			session.setAttribute("gold", gold);
		} else {
			int randnum = random.nextInt(50 - -50 + 1) + -50;
			gold += randnum;
			currentmessages.add("You got " + randnum + "at the casino");
			session.setAttribute("messages", currentmessages);
			session.setAttribute("gold", gold);
		}
		return "redirect:/";
		
	}
	
}
