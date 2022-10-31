package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
	
	@Id
	private String bookId;
	private String bookName;
	private String description;
	public String getBookId() {
		// TODO Auto-generated method stub
		return this.bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
	

}
