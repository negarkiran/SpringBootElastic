package com.kiran.springbootstarter.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.springbootstarter.book.model.Book;
import com.kiran.springbootstarter.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		bookService.findAll().forEach(book->books.add(book));
		return books;
	}
}
