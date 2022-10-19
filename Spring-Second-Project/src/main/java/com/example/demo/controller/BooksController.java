package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.model.Books;


import com.example.demo.service.BooksService;

@RestController
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/getAllbook")
	public List<Books> getAllBooks() {
		System.out.println("Got All Books Successfully");
		return booksService.getAllBooks();
	}

	@GetMapping("/getbook/{bookid}")
	public Books getBooks(@PathVariable("bookid") int bookid) {
		System.out.println("Got Successfully");
		return booksService.getBooksById(bookid);
	}

	@DeleteMapping("/delete/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid) {
		System.out.println("Deleted Successfully");
		booksService.delete(bookid);
	}

	@PostMapping("/save")
	public ResponseEntity saveBook(@RequestBody Books books) {
		Books book = booksService.saveOrUpdate(books);
		System.out.println("Saved Successfully");
		return new ResponseEntity(book, "Saved Successfully");
	}

	@PutMapping("/update")
	public ResponseEntity update(@RequestBody Books books) {
		Books updatebook = booksService.saveOrUpdate(books);
		System.out.println("Updated Successfully");
		return new ResponseEntity(updatebook, "Updated Successfully");
	}
}
