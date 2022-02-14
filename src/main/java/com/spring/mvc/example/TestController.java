package com.spring.mvc.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	
	@GetMapping("/all")
	public String showAll(Model model) {
		
		List<Book> books = Arrays.asList(new Book(1,"uno","uno"),new Book(2,"dos","dos"));
	    model.addAttribute("books", books);
	    return "books/allBooks";
	}
		
	@GetMapping("/create")
	public String showCreateForm(Model model) {
	    BooksCreationDto booksForm = new BooksCreationDto();
System.out.println("entrando en create");
	   
	        booksForm.addBook(new Book(1,"uno","uno"));
	        booksForm.addBook(new Book(2,"dos","dos"));
	        booksForm.addBook(new Book(3,"dos","dos"));

	    model.addAttribute("form", booksForm);
	    return "createBooksForm";
	}
	
	@PostMapping("/save")
	public String saveBooks(@ModelAttribute BooksCreationDto form, Model model) {
		System.out.println("The books");
	   form.getBooks().forEach(x->System.out.println(x));

//	    model.addAttribute("books", bookService.findAll());
	    return "redirect:/books/all";
	}
}
