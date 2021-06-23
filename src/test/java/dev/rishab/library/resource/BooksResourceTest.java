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

package dev.rishab.library.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dev.rishab.library.entity.Book;
import dev.rishab.library.entity.Book.Format;
import dev.rishab.library.util.Generator;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

/**
 * @author eric.wittmann@gmail.com
 */
@QuarkusTest
class BooksResourceTest {

    @BeforeAll
    public static void beforeAll() throws Exception {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    void testAddBook() {
        // Should be no books in the library yet
        Book[] books = RestAssured.given().when()
            .get("/books")
        .then()
            .statusCode(200)
            .extract().as(Book[].class);
        Assertions.assertEquals(0, books.length);

        // Add a book
        Book bookToAdd = new Book();
        bookToAdd.setDescription("My first book.");
        bookToAdd.setFormat(Format.PAPERBACK);
        bookToAdd.setIsbn(Generator.generateIsbn());
        bookToAdd.setLanguage("EN");
        bookToAdd.setNumberOfPages(369);
        bookToAdd.setTitle("Test Book Pt 1");
        Book addedBook = RestAssured.given().when()
            .contentType("application/json")
            .body(bookToAdd)
            .post("/books")
        .then()
            .statusCode(200)
            .extract().as(Book.class);
        Assertions.assertEquals(bookToAdd.getTitle(), addedBook.getTitle());
        Assertions.assertEquals(bookToAdd.getIsbn(), addedBook.getIsbn());

        // NOW we should have a book
        books = RestAssured.given().when()
            .get("/books")
        .then()
            .statusCode(200)
            .extract().as(Book[].class);
        Assertions.assertEquals(1, books.length);
        Assertions.assertEquals(bookToAdd.getTitle(), books[0].getTitle());
    }

}
