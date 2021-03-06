package com.dhollinger.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhollinger.dojosNinjas.models.Ninja;
import com.dhollinger.dojosNinjas.repos.NinjaRepo;
@Service
public class NinjaServ {
	@Autowired
	private NinjaRepo repo;
	
	public NinjaServ(NinjaRepo repo) {
		this.repo = repo;
	}
	public List<Ninja> getAll(){
		return repo.findAll();
	}
	public Ninja getOne(Long id) {
		Optional<Ninja> opNinja = repo.findById(id);
		if(opNinja.isPresent()) {
			return opNinja.get();
		} else {
			return null;
		}
	}
	public Ninja saveOne(Ninja ninja) {
		return repo.save(ninja);
	}
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}
