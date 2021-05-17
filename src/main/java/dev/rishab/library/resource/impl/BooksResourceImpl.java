
package dev.rishab.library.resource.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import dev.rishab.library.beans.Book;
import dev.rishab.library.resource.BooksResource;
import dev.rishab.library.service.LibraryService;

public class BooksResourceImpl implements BooksResource {

	@Inject
	LibraryService bookService;
	
	@Context
	UriInfo uriInfo;

	/**
	 * @see dev.rishab.library.resource.BooksResource#listBooks()
	 */
	@Override
	public List<Book> listBooks() {
		return bookService.fetchAllBooks();
	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#addBook(dev.rishab.library.beans.Book)
	 */
	@Override
	public Book addBook(Book data) {
		Book book = bookService.addBook(data);
		return book;
	}

//   public Response addBook(Book data, @Context UriInfo uriInfo) {
//        data.setIsbn(Generator.generateIsbn());
//        Book book = bookService.addBook(data);
//
//        URI uri = uriInfo.getAbsolutePathBuilder()
//                .path(book.getIsbn())
//                .build();
//
//        return Response.created(uri)
//                .entity(book)
//                .build();
//   }
	
	/**
	 * @see dev.rishab.library.resource.BooksResource#getBook(java.lang.String)
	 */
	@Override
	public Book getBook(String bookId) {
		Book book = bookService.fetchBookById(bookId);
		return book;
	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#updateBook(java.lang.String,
	 *      dev.rishab.library.beans.Book)
	 */
	@Override
	public void updateBook(String bookId, Book data) {
		data.setIsbn(bookId);
		bookService.updateBook(data);
	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#deleteBook(java.lang.String)
	 */
	@Override
	public void deleteBook(String bookId) {
		bookService.deleteBook(bookId);

	}

}
