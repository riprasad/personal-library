package dev.rishab.library.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dev.rishab.library.entity.Book;
import dev.rishab.library.exception.DataNotFoundException;
import dev.rishab.library.repository.BookRepository;
import dev.rishab.library.service.BookService;

@ApplicationScoped
@Named("panache")
public class BookServiceUsingPanache implements BookService {

	@Inject
	BookRepository repository;

	@Override
	public List<Book> fetchAllBooks() {

		return repository.listAll();
	}

	@Override
	public Book fetchBookById(String isbn) {
		return repository.findByIdOptional(isbn)
				.orElseThrow(() -> new DataNotFoundException("Book with isbn " + isbn + " doesn't exist!"));
	}

	@Override
	@Transactional
	public Book addBook(Book book) {
		repository.persist(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteBook(String isbn) {
		return repository.deleteById(isbn);
	}

}
