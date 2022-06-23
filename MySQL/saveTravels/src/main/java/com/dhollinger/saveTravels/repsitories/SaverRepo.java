package com.dhollinger.saveTravels.repsitories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhollinger.saveTravels.models.Saver;
@Repository
public interface SaverRepo  extends CrudRepository<Saver, Long>{
	List<Saver> findAll();
}
