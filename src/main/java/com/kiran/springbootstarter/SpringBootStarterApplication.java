package com.kiran.springbootstarter;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.kiran.springbootstarter.book.model.Book;
import com.kiran.springbootstarter.book.service.BookService;

@SpringBootApplication
public class SpringBootStarterApplication implements CommandLineRunner {
	
	@Autowired
    private ElasticsearchOperations es;
	
	@Autowired
    private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}
	
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}
	
	public CommandLineRunner run(RestTemplate restTemplate){
		return args ->{
			Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			System.out.println(quote.toString());
		};
	}*/
	
	@Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();
        bookService.deleteAll();
        bookService.save(new Book("1001", "Elasticsearch Basics", "Ram Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Ram Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Ram Posa", "21-MAR-2017"));

        fetchAllBooks();

    }
	
	private void fetchAllBooks() {
		System.out.println("-------------------------------");
		bookService.findAll().forEach(book->System.out.println(book));
	}

	private void printElasticSearchInfo() {
		System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
	}
}
