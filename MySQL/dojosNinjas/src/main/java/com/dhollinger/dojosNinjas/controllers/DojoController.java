package com.dhollinger.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.dojosNinjas.models.Dojo;
import com.dhollinger.dojosNinjas.models.Ninja;
import com.dhollinger.dojosNinjas.services.DojoServ;
import com.dhollinger.dojosNinjas.services.NinjaServ;

@Controller
public class DojoController {
	private final DojoServ serv;
	private final NinjaServ ninjaServ;
	public DojoController(DojoServ serv, NinjaServ ninjaServ) {
		this.serv = serv;
		this.ninjaServ = ninjaServ;
	}
	@RequestMapping("/")
	public String redirectToIndex() {
		return "redirect:/dojos";
	}
	@RequestMapping("/dojos")
	public String renderIndex(Model model, @ModelAttribute("dojo") Dojo dojo, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("allDojos", serv.getAll());
		return "dojoIndex.jsp";
	}
	@RequestMapping("/dojo/new")
	public String createOne(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoIndex.jsp";
		} else {
			serv.saveOne(dojo);
			return "redirect:/dojos";
		}
	}
	@RequestMapping("/view/dojo/{id}")
	public String viewOne(@PathVariable("id") Long id, Model model, @ModelAttribute("dojo") Dojo dojo) {
		model.addAttribute("dojo", serv.getOne(id));
		model.addAttribute("allNinjas", ninjaServ.getAll().removeAll(serv.getOne(id).getNinjas()));
		return "viewdojo.jsp";
	}
}
