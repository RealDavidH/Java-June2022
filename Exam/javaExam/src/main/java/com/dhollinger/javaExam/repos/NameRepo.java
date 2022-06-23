package com.dhollinger.javaExam.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhollinger.javaExam.models.Name;
import com.dhollinger.javaExam.models.User;

@Repository
public interface NameRepo extends CrudRepository<Name, Long>{
	List<Name> findAll();
	Optional<Name> findByName(String name);
	List<Name> findAllByUser(User user);
	List<Name> findByUserNotContains(User user);
}
