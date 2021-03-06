package com.dhollinger.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.bookclub.models.Book;
import com.dhollinger.bookclub.models.User;
import com.dhollinger.bookclub.servs.BookServ;
import com.dhollinger.bookclub.servs.UserServ;
@Controller
public class BookController {
	private final UserServ userServ;
	private final BookServ bookServ;
	
	public BookController(UserServ userServ, BookServ bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	@RequestMapping("/book/add")
	public String renderBookForm(@ModelAttribute("book") Book book) {

		return "addbook.jsp";
	}
	@RequestMapping("/book/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "addbook.jsp";
		} 
		book.setUser(userServ.getOne((Long)session.getAttribute("uuid")));
		bookServ.saveOne(book);
		return "redirect:/books";
		
	}
	@GetMapping("/book/{id}")
	public String displayBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("oneBook", bookServ.getOne(id));
		model.addAttribute("uuid", session.getAttribute("uuid"));
		return "displaybook.jsp";
	}
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, @ModelAttribute("book") Book book) {
		model.addAttribute("oneBook", bookServ.getOne(id));
		return "editbook.jsp";
	}
	@PutMapping("/book/update/{id}")
	public String updateOne(@PathVariable("id")Long id, @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "editbook.jsp";
		}
		book.setUser(userServ.getOne((Long)session.getAttribute("uuid")));
		bookServ.saveOne(book);
		return "redirect:/book/" + id;
	}
	@RequestMapping("/book/delete/{id}")
	public String deleteOne(@PathVariable("id") Long id) {
		bookServ.deleteOne(id);
		return "redirect:/books";
	}
	@RequestMapping("/bookmarket")
	public String renderBookmarket(Model model, HttpSession session) {
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		List <Book> booklist = bookServ.getAll();
		
		
		model.addAttribute("user", user);
		model.addAttribute("inMarket", booklist);
		return "bookmarket.jsp";
	}
	@RequestMapping("/book/borrow/{id}")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session) {

		return "redirect:/bookmarket";
	}
	
	
}
