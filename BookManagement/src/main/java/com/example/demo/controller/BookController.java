package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Book createBook(@RequestBody Book book) {
		logger.info("in create Book method");
		return service.addBook(book);
	}
	
	@GetMapping
	private List<Book> showBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/{bookId}")
	private Book showBookById(@PathVariable String bookId) {
		return service.getBookById(bookId);
	}
	
	@GetMapping("/{bookName}")
	private Book showBookByName(@PathVariable String bookName) {
		return service.getBookByName(bookName);
	}
	
	@PutMapping
	private Book editBook(@RequestBody Book book )  {
		return service.updateBook(book);
	}
	
	@DeleteMapping("/{bookId}")
	private String removeBookById(@PathVariable String bookId) {
		return service.deleteBookById(bookId);
	}
	
}
