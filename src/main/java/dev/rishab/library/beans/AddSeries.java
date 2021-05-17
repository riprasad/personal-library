
package dev.rishab.library.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Type for AddSeries
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "authorId"
})
public class AddSeries {

    @JsonProperty("name")
    private String name;
    @JsonProperty("authorId")
    private Integer authorId;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("authorId")
    public Integer getAuthorId() {
        return authorId;
    }

    @JsonProperty("authorId")
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

}
