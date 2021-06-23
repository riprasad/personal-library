
package dev.rishab.library.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "numberOfPages",
    "description",
    "format",
    "isbn",
    "language",
    "series",
    "title",
    "publishedOn",
    "publisher",
    "keywords",
    "authors"
})
@Entity
public class Book {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPages")
    @JsonPropertyDescription("")
    private Integer numberOfPages;
    /**
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("")
    @Column(columnDefinition="LONGVARCHAR")
    private String description;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    @JsonPropertyDescription("")
    private Book.Format format;
    /**
     * 
     */
    @JsonProperty("isbn")
    @JsonPropertyDescription("")
    @Id
    private String isbn;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("")
    private String language;
    /**
     * 
     */
    @JsonProperty("series")
    @JsonPropertyDescription("")
    @ElementCollection
    private List<String> series = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("")
    private String title;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publishedOn")
    @JsonPropertyDescription("")
    private String publishedOn;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publisher")
    @JsonPropertyDescription("")
    private String publisher;
    /**
     * 
     */
    @JsonProperty("keywords")
    @JsonPropertyDescription("")
    @ElementCollection
    private List<String> keywords = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("authors")
    @JsonPropertyDescription("")
    @ElementCollection
    private List<String> authors = new ArrayList<String>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPages")
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPages")
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    public Book.Format getFormat() {
        return format;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    public void setFormat(Book.Format format) {
        this.format = format;
    }

    /**
     * 
     */
    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    /**
     * 
     */
    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     */
    @JsonProperty("series")
    public List<String> getSeries() {
        return series;
    }

    /**
     * 
     */
    @JsonProperty("series")
    public void setSeries(List<String> series) {
        this.series = series;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publishedOn")
    public String getPublishedOn() {
        return publishedOn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publishedOn")
    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * 
     */
    @JsonProperty("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * 
     */
    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("authors")
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public enum Format {

        PAPERBACK("PAPERBACK"),
        KINDLE_EDITION("KINDLE_EDITION"),
        PDF("PDF"),
        DOC("DOC"),
        AUDIOBOOK("AUDIOBOOK");
        private final String value;
        private final static Map<String, Book.Format> CONSTANTS = new HashMap<String, Book.Format>();

        static {
            for (Book.Format c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Format(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Book.Format fromValue(String value) {
            Book.Format constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
