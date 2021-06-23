package dev.rishab.library.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.rishab.library.entity.Book;

@ApplicationScoped
public interface BookService {
	
	/**
	 * Fetches the list of all books 
	 * 
	 * @return List<Book>
	 */
	List<Book> fetchAllBooks();
	
	/**
	 * Fetch book by Id
	 * 
	 * @param isbn
	 * @return Book
	 */
	Book fetchBookById(String isbn);
	
	/**
	 * Adds a new book
	 * 
	 * @param book
	 * @return Book
	 */
	Book addBook(Book book);
	
	/**
	 * Updates an existing entry of the book
	 * 
	 * @param book
	 * @return Book
	 */
	Book updateBook(Book book);
	
	/**
	 * Deletes the entry of the book
	 * 
	 * @param isbn
	 * @return true if the delete operation was successful, otherwise false
	 */
	Boolean deleteBook(String isbn);

}
