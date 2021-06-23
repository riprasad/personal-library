package dev.rishab.library.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.rishab.library.entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<Book, String> {

}
