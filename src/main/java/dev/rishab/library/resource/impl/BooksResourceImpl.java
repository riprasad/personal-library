
package dev.rishab.library.resource.impl;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dev.rishab.library.beans.Book;
import dev.rishab.library.resource.BooksResource;
import dev.rishab.library.service.BookService;
import dev.rishab.library.util.Generator;

/**
 * @author eric.wittmann@gmail.com
 */
public class BooksResourceImpl implements BooksResource {

	@Inject
	BookService bookService;

	/**
	 * @see dev.rishab.library.resource.BooksResource#listBooks()
	 */
	@Override
	public List<Book> listBooks() {
		return bookService.fetchAllBooks();
	}

	/**
	 * @return
	 * @see dev.rishab.library.resource.BooksResource#addBook(dev.rishab.library.beans.Book)
	 */
	@Override
	public Response addBook(Book data, @Context UriInfo uriInfo) {
		data.setIsbn(Generator.generateIsbn());
		Book book = bookService.addBook(data);

		URI uri = uriInfo.getAbsolutePathBuilder()
				.path(book.getIsbn())
				.build();

		return Response.created(uri)
				.entity(book)
				.build();

	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#getBook(java.lang.String)
	 */
	@Override
	public Book getBook(String bookId) {
		Book book = bookService.fetchBookById(bookId);
		return book;
	}

	/**
	 * @return
	 * @see dev.rishab.library.resource.BooksResource#updateBook(java.lang.String,
	 *      dev.rishab.library.beans.Book)
	 */
	@Override
	public Book updateBook(String bookId, Book data) {
		data.setIsbn(bookId);
		return bookService.updateBook(data);

	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#deleteBook(java.lang.String)
	 */
	@Override
	public void deleteBook(String bookId) {
		bookService.deleteBook(bookId);

	}

}
