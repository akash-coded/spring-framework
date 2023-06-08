package com.task.solution.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.solution.model.Book;
import com.task.solution.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping
	public List<Book> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
		if (title != null || author != null) {
			return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(title, author);
		}
		
		return bookRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestParam String title, @RequestParam String author) {
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		Book savedBook = bookRepository.save(newBook);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestParam(required = false) String title, @RequestParam(required = false) String author) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			if (title != null) {
				book.setTitle(title);
			}
			
			if (author != null) {
				book.setAuthor(author);
			}
			
			Book updatedBook = bookRepository.save(book);
			return ResponseEntity.ok(updatedBook);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.delete(optionalBook.get());
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
