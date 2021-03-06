package com.dhollinger.saveTravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.saveTravels.models.Saver;
import com.dhollinger.saveTravels.services.SaverService;

@Controller
public class SaverController {
	private final SaverService saverService;
	
	public SaverController(SaverService saverService) {
		this.saverService = saverService;
	}
	@RequestMapping("/expenses")
	public String renderExpenses(@ModelAttribute("saver") Saver saver, Model model) {
		model.addAttribute("allSavers", saverService.allsavers());
		return "exenses.jsp";
	}
	@PostMapping("/process")
	public String processFormData(@Valid @ModelAttribute("saver") Saver saver, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/exenses.jsp";
		} else {
			saverService.saveSaver(saver);
			
			return "redirect:/expenses";
		}
	}
	@RequestMapping("/edit/{id}")
	public String renderEdit(@PathVariable("id") Long id, Model model, @ModelAttribute("saver")Saver saver) {
			model.addAttribute("oneSaver", saverService.findSaver(id));
			return "edit.jsp";
	}
	@RequestMapping("/update/{id}")
	public String updateOne(@PathVariable("id") Long id, @Valid @ModelAttribute("saver") Saver saver, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			saverService.saveSaver(saver);
			return "redirect:/expenses";
		}
	}
	@RequestMapping("/delete/{id}")
	public String deleteOne(@PathVariable("id") Long id) {
		saverService.deleteSaver(id);
		return "redirect:/expenses";
	}
	@RequestMapping("/show/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneSaver", saverService.findSaver(id));
		return "show.jsp";
	}
}
