
package dev.rishab.library.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Type for Series
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seriesId",
    "name",
    "author"
})
public class Series {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("seriesId")
    private Integer seriesId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    @JsonPropertyDescription("")
    private Author author;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("seriesId")
    public Integer getSeriesId() {
        return seriesId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("seriesId")
    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

}
