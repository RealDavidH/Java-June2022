package com.dhollinger.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhollinger.saveTravels.models.Saver;
import com.dhollinger.saveTravels.repsitories.SaverRepo;
@Service
public class SaverService {
	@Autowired
	private SaverRepo saverRepo;

	public SaverService (SaverRepo saverRepo) {
		this.saverRepo = saverRepo;
	}
	public List<Saver> allsavers(){
		return saverRepo.findAll();
	}
	public Saver findSaver(Long id) {
		Optional<Saver> optionalSaver = saverRepo.findById(id);
		if(optionalSaver.isPresent()) {
			return optionalSaver.get();
		} else {
			return null;
		}
	}
	public Saver saveSaver(Saver saver) {
		return saverRepo.save(saver);
	}
	public void deleteSaver(Long id) {
		saverRepo.deleteById(id);
	}
}
