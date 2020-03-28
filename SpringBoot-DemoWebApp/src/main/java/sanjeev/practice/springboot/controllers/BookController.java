package sanjeev.practice.springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sanjeev.practice.springboot.models.Book;

@RestController
public class BookController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		System.out.println("hello....   fds ");
		return Arrays.asList(
				new Book("physics", 50.5f, "Sanjeev"), 
				new Book("chemistry", 50.5f, "Rajeev")
				);
		
	}

}
