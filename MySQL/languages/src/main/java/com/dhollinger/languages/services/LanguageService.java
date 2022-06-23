package com.dhollinger.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhollinger.languages.models.Language;
import com.dhollinger.languages.repos.LanguageRepo;


@Service
public class LanguageService {
	@Autowired
	private LanguageRepo languageRepo;
	public LanguageService (LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	public List<Language> alllangauge(){
		return languageRepo.findAll();
	}
	public Language findalllangauge(Long id) {
		Optional<Language> optionallangauge = languageRepo.findById(id);
		if(optionallangauge.isPresent()) {
			return optionallangauge.get();
		} else {
			return null;
		}
	}
	public Language savelangauge(Language language) {
		return languageRepo.save(language);
	}
	public void deleteLangauge(Long id) {
		languageRepo.deleteById(id);
	}
}
