package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Book;

public interface BookRepository extends MongoRepository<Book,String> {

	@Query("{'bookName':?0}")
	List<Book> findByBookName(String bname);
	
}
