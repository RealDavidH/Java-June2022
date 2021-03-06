package com.dhollinger.bookclub.servs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhollinger.bookclub.models.Book;
import com.dhollinger.bookclub.repos.BookRepo;
@Service
public class BookServ {
	@Autowired
	private BookRepo repo;
	
	public BookServ(BookRepo repo) {
		this.repo = repo;
	}
	
	public List<Book> getAll(){
		return repo.findAll();
	}
	public Book getOne(Long id) {
		Optional <Book> opBook = repo.findById(id);
		if(!opBook.isPresent()) {
			return null;
		}
		return opBook.get();
	}
	public Book saveOne(Book book) {
		return repo.save(book);
	}
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	
}
