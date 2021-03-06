package com.dhollinger.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dhollinger.bookclub.servs.BookServ;
import com.dhollinger.bookclub.servs.UserServ;
@Controller
public class IndexController {
	private final UserServ userServ;
	private final BookServ bookServ;
	public IndexController(BookServ bookServ, UserServ userServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}
	@GetMapping("/books")
	public String renderIndex(Model model, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getOne( (Long) session.getAttribute("uuid")));
		model.addAttribute("allBooks", bookServ.getAll());
		return "index.jsp";
	}
}
