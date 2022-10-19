package com.example.demo.service;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.custom.exception.EmptyInputException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookRepository repo;
	
	public Book addBook(Book book) {
		logger.info("in addBook method");
		if(book.getBookName().isEmpty() || book.getBookName().length() == 0) {
			throw new EmptyInputException("601","Please Send proper name,it is blank");
		}
		try {
			return repo.save(book);
		}
		//null object passed
		catch(IllegalArgumentException e) {
			throw new BusinessException("602","the given info about book is null : "+e.getMessage());
		}
		catch(Exception e) {
			throw new BusinessException("603","Something went wrong in the service layer : "+e.getMessage());
		}
	}
	
	public List<Book> getBooks() {
		logger.info("in getBooks method");
		try {
			List<Book> book = repo.findAll();
			if(book.isEmpty()) {
				throw new BusinessException("604","There are no books available");
			}
			return repo.findAll();
		}
		catch(Exception e) {
			throw new BusinessException("605","Something went wrong in the service layer while fetching all employees : "+e.getMessage());
		}
		
	}
	
	public Book getBookById(String bookId) {
		logger.info("in getBookById method");
		try {
			return repo.findById(bookId).get();
		}
		catch(IllegalArgumentException e) {
			throw new BusinessException("606","The given id id null,please enter the id");
		}
//		catch(NoSuchElementException e) {
//			throw new BusinessException("607","No book with given id exists");
//		}
		
	}
	
	public List<Book> getBookByName(String bname) {
		logger.info("in getBookByName method");
		try {
			//return repo.findByBookName(bname);
			List<Book> books =   (List<Book>) repo.findByBookName(bname);
			if(books.size()==0) {
				throw new BusinessException("607","The given bookname does not exist in the database");
			}
			else {
				return books;
			}
			
		}
		catch(IllegalArgumentException e) {
			throw new BusinessException("608","The given bookname is null,please enter the bookname");
		}
		
	}
	
	public Book updateBook(Book book) {
		logger.info("in updateBook method");
		try {
			Book bk = repo.findById(book.getBookId()).get();
			bk.setBookName(book.getBookName());
			bk.setDescription(book.getDescription());
			return repo.save(bk);
		}
		catch(IllegalArgumentException e) {
			throw new BusinessException("610","The given book values are null,please enter the book details");
		}
//		catch(NoSuchElementException e) {
//			throw new BusinessException("611","No book with given bookid exists");
//		}

		
		
	}
	
	public String deleteBookById(String bookId) {
		logger.info("in deleteBookById method");
		try {
			Book book = repo.findById(bookId).get();
			repo.deleteById(bookId);
			return "book deleted";
		}
		catch(IllegalArgumentException e) {
			throw new BusinessException("612","The given bookid is null,please enter the bookid");
		}
//		catch(NoSuchElementException e) {
//			throw new BusinessException("613","No book with given bookid exists");
//		}
	}
	
	
}
