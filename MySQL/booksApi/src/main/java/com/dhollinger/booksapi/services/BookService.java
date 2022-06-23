package com.dhollinger.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dhollinger.booksapi.models.Book;
import com.dhollinger.booksapi.repositories.BookRepo;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
