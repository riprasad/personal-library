/*
 * Copyright 2021 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * @author eric.wittmann@gmail.com
 */
public class BooksResourceImpl implements BooksResource {

	@Inject
	private BookService bookService;

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
		Book book = bookService.addBook(data);
		URI uri = uriInfo.getAbsolutePathBuilder().path(book.getIsbn()).build();
		return Response.created(uri).entity(book).build();

	}

	/**
	 * @see dev.rishab.library.resource.BooksResource#getBook(java.lang.String)
	 */
	@Override
	public Book getBook(String bookId) {
		return bookService.fetchBookById(bookId);
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
