package com.kiran.springbootstarter.book.service;

import java.util.List;

import com.kiran.springbootstarter.book.model.Book;

public interface BookService {
	
	public Book save(Book book);
	
	public void delete(Book book);
	
	public void deleteAll();
	
	public Book findOne(String id);
	
	public Iterable<Book> findAll();
	
	public List<Book> findByAuthor(String author);
	
	public List<Book> findByTitle(String title);
}
