package com.kiran.springbootstarter.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.springbootstarter.book.model.Book;
import com.kiran.springbootstarter.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	@Override
	public void deleteAll(){
		bookRepository.deleteAll();
	}

	@Override
	public Book findOne(String id) {
		return bookRepository.findOne(id);
	}

	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

}
