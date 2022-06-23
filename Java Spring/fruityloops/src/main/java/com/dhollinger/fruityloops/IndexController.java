package com.dhollinger.fruityloops;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("")
	public String index(Model model) {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Banana", 2.5));
		items.add(new Item("Orange", 1.5));
		items.add(new Item("Mango", 5.5));
		items.add(new Item("Jackfruit", 10));
		System.out.println("yo mama");
		model.addAttribute("items", items);
		
		return "index.jsp";
		
	}
}
