package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository repo;
	
	public Book addBook(Book book) {
		return repo.save(book);
	}
	
	public List<Book> getBooks() {
		return repo.findAll();
	}
	
	public Book getBookById(String bookId) {
		return repo.findById(bookId).get();
	}
	
	public Book getBookByName(String bname) {
		return repo.findByBookName(bname);
	}
	
	public Book updateBook(Book book) {
		Book bk = repo.findById(book.getBookId()).get();
		bk.setBookName(book.getBookName());
		bk.setDescription(book.getDescription());
		return repo.save(bk);
	}
	
	public String deleteBookById(String bookId) {
		repo.deleteById(bookId);
		return "book deleted";
	}
	
	
}
