package com.dhollinger.languages.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhollinger.languages.models.Language;
@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
	List<Language> findAll();
}
