package com.kiran.springbootstarter.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.kiran.springbootstarter.SpringBootStarterApplication;
import com.kiran.springbootstarter.book.model.Book;
import com.kiran.springbootstarter.book.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarterApplication.class)
public class BookServiceTest {
	
	@Autowired
    private BookService bookService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Book.class);
        esTemplate.createIndex(Book.class);
        esTemplate.putMapping(Book.class);
        esTemplate.refresh(Book.class);
    }
    
    @Test
    public void testSave() {

        Book book = new Book("1001", "Elasticsearch Basics", "Ram Posa", "23-FEB-2017");
        Book testBook = bookService.save(book);

        assertNotNull(testBook.getId());
        assertEquals(testBook.getTitle(), book.getTitle());
        assertEquals(testBook.getAuthor(), book.getAuthor());
        assertEquals(testBook.getReleaseDate(), book.getReleaseDate());

    }

}
