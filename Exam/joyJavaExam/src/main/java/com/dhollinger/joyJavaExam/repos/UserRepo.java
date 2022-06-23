package com.dhollinger.joyJavaExam.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhollinger.joyJavaExam.models.Name;
import com.dhollinger.joyJavaExam.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	Optional<User> findByEmail(String email); 
	List<User> findAllByName(Name name);
	List<User> findByNameNotContains(Name name);
}

