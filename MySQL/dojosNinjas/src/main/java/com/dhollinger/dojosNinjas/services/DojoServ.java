package com.dhollinger.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhollinger.dojosNinjas.models.Dojo;
import com.dhollinger.dojosNinjas.repos.DojoRepo;

@Service
public class DojoServ {
	@Autowired
	private DojoRepo repo;
	
	public DojoServ(DojoRepo repo) {
		this.repo = repo;
	}
	public List<Dojo> getAll(){
		return repo.findAll();
	}
	public Dojo getOne(Long id) {
		Optional<Dojo> opDojo = repo.findById(id);
		if(opDojo.isPresent()) {
			return opDojo.get();
		} else {
			return null;
		}
	}
	public Dojo saveOne(Dojo dojo) {
		return repo.save(dojo);
	}
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}
