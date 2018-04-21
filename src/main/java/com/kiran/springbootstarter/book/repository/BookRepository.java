package com.kiran.springbootstarter.book.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.kiran.springbootstarter.book.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByTitle(String title);

}
