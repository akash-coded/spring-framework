package demo.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.microservices.model.Book;
import demo.microservices.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED, reason="Book added successfully")
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
}
