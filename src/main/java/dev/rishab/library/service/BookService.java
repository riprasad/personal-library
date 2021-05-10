package dev.rishab.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.rishab.library.beans.Book;
import dev.rishab.library.beans.Book.Format;
import dev.rishab.library.database.DatabaseStub;
import dev.rishab.library.util.Generator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApplicationScoped
@NoArgsConstructor
public class BookService {

	@Inject
	private DatabaseStub database;
	
	@Getter
	@Setter
	private Map<String, Book> books = database.getBooks();

	public List<Book> fetchAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	public Book fetchBookById(String isbn) {
		return books.get(isbn);

	}

	public Book addBook(Book book) {
		books.put(Generator.generateIsbn(), book);
		return book;
	}

	public Book updateBook(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	public Book deleteBook(String isbn) {
		return books.remove(isbn);
	}

	@PostConstruct
	private void seed() {
		Book book1 = new Book();
		book1.setIsbn(Generator.generateIsbn());
		book1.setNumberOfPages(326);
		book1.setDescription(
				"Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6. This Jolt award-winning classic has now been thoroughly updated to take full advantage of the latest language and library features. The support in modern Java for multiple paradigms increases the need for specific best-practices advice, and this book delivers.");
		book1.setFormat(Format.PAPERBACK);
		book1.setLanguage("English");
		book1.setTitle("Effective Java");
		book1.setAuthors(List.of("Bloch Joshua"));
		book1.setPublisher("Addison-Wesley Professional");
		book1.setPublishedOn("18-Dec-2017");

		books.put(book1.getIsbn(), book1);
	}

}
