package com.dhollinger.loginreg.servs;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dhollinger.loginreg.models.LoginUser;
import com.dhollinger.loginreg.models.User;
import com.dhollinger.loginreg.repos.UserRepo;

@Service
public class UserServ {
	@Autowired
	private UserRepo repo;
	public UserServ(UserRepo repo) {
		this.repo = repo;
	}
	
	public List<User> getAll(){
		return repo.findAll();
	}
	public Optional<User> getByEmail(String email){
		return repo.findByEmail(email);
	}
	public User getOne(Long id) {
		Optional<User> opUser = repo.findById(id);
		if(opUser.isPresent()) {
			return opUser.get();
		} else {
			return null;
		}
	}
	public User saveOne(User user) {
		return repo.save(user);
	}
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	public User register(User newUser, BindingResult result) {
		System.out.println(newUser.getConfirmPassword());
		System.out.println(newUser.getPassword());
		
		if(!newUser.getConfirmPassword().equals(newUser.getPassword())) {
			result.rejectValue("password", "matches", "Passwords must match!");
		}
		
		if(repo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "unquie", "Email already in use!");
		}
		if(result.hasErrors()) {
			return null;
		} 
			
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return repo.save(newUser);
	}
	public User login(LoginUser loginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> opUser = repo.findByEmail(loginUser.getEmail());
		if(!opUser.isPresent()) {
			result.rejectValue("email", "unique", "Invalid Credentials");
			return null;
		}
		User user = opUser.get();
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Invalid Credentials");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		} 
			
		return user;
		}
		
}
