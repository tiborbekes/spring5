package com.bekes.springdemo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bekes.springdemo.entity.Author;
import com.bekes.springdemo.entity.Book;
import com.bekes.springdemo.entity.Publisher;
import com.bekes.springdemo.repository.AuthorRepository;
import com.bekes.springdemo.repository.BookRepository;
import com.bekes.springdemo.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Started in Bootstrap");
		
		Publisher pub = new Publisher("Publisher", "Street 12/4", "Bratislava", "Slovakia", "12345");
		publisherRepository.save(pub);
		
		System.out.println("Publisher count: " + publisherRepository.count());
		
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(pub);
		pub.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(pub);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE development without EJB", "35468648");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(pub);
		pub.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(pub);
		
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Publisher number of books: " + pub.getBooks().size());
		
	}

}
