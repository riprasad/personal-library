package dev.rishab.library.resource;

import dev.rishab.library.beans.Book;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/books")
public interface BooksResource {
	/**
	 * returns a list of books available.
	 */
	@GET
	@Produces("application/json")
	List<Book> listBooks();

	/**
	 * This operation is used to add a book to the library.
	 */
	@POST
	@Consumes("application/json")
	Response addBook(Book data, @Context UriInfo uriInfo);

	/**
	 * Gets the details of a single instance of a `Book`.
	 */
	@Path("/{bookId}")
	@GET
	@Produces("application/json")
	Book getBook(@PathParam("bookId") String bookId);

	/**
	 * Updates an existing `Book`.
	 */
	@Path("/{bookId}")
	@PUT
	@Consumes("application/json")
	Book updateBook(@PathParam("bookId") String bookId, Book data);

	/**
	 * Deletes an existing `Book`.
	 */
	@Path("/{bookId}")
	@DELETE
	void deleteBook(@PathParam("bookId") String bookId);
}
