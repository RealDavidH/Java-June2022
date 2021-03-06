package com.dhollinger.dojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.dojosNinjas.models.Dojo;
import com.dhollinger.dojosNinjas.models.Ninja;
import com.dhollinger.dojosNinjas.services.NinjaServ;

@Controller
public class NinjaController {
	private final NinjaServ serv;
	public NinjaController(NinjaServ serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoIndex.jps";
		} else {
			serv.saveOne(ninja);
			return "redirect:/view/dojo/" + ninja.getDojo().getId();
		}
	}
	@RequestMapping("/remove/ninja/{id}")
	public String removeDojo(@PathVariable("id") Long id, Dojo dojo) { // need to fix this 
		Ninja ninja = serv.getOne(id);
		Long dojoid = ninja.getDojo().getId();
		Dojo alldojos = ninja.getDojo();
		System.out.println(alldojos);
		return "redirect:/view/dojo/" + dojoid;
	}
}
