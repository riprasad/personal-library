package dev.rishab.library.database;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import dev.rishab.library.beans.Author;
import dev.rishab.library.beans.Book;
import lombok.Getter;

@ApplicationScoped
public class DatabaseStub {
	
	@Getter
	private Map<String, Book> books = new HashMap<>();
	
	@Getter
	private Map<String, Author> authors = new HashMap<>();

}
