package com.dhollinger.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhollinger.languages.models.Language;
import com.dhollinger.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/")
	public String redirctToHome() {
		return "redirect:/languages";
	}
	@RequestMapping("/languages")
	public String renderIndex(Model model, @ModelAttribute("language") Language language ) {
		model.addAttribute("allLanguage", languageService.alllangauge());
		return "languageIndex.jsp";
	}
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languageIndex.jsp";
		} else {
			languageService.savelangauge(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/edit/{id}")
	public String renderEdit(@PathVariable("id") Long id, Model model, @ModelAttribute("language") Language language) {
		model.addAttribute("oneLanguage", languageService.findalllangauge(id));
		return "editLanguage.jsp";
	}
	@RequestMapping("/update/{id}")
	public String updateOne(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("oneLanguage", languageService.findalllangauge(id));
			return "editLanguage.jsp";
		} else {
			languageService.savelangauge(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/view/{id}")
	public String renderView(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneLanguage", languageService.findalllangauge(id));
		return "viewLanguage.jsp";
	}
}
