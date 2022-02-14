package com.spring.mvc.example;

import java.util.ArrayList;
import java.util.List;

public class BooksCreationDto {
    private List<Book> books = new ArrayList<Book>();

    // default and parameterized constructor

    public void addBook(Book book) {
        this.books.add(book);
    }

    
	public BooksCreationDto() {
		
		// TODO Auto-generated constructor stub
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
    
}