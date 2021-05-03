
package dev.rishab.library.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "familyName",
    "givenName",
    "dateOfBirth",
    "dateOfDeath",
    "nationality"
})
public class Author {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("familyName")
    @JsonPropertyDescription("")
    private String familyName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("givenName")
    @JsonPropertyDescription("")
    private String givenName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    @JsonPropertyDescription("")
    private String dateOfBirth;
    /**
     * 
     */
    @JsonProperty("dateOfDeath")
    @JsonPropertyDescription("")
    private String dateOfDeath;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nationality")
    @JsonPropertyDescription("")
    private String nationality;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("familyName")
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("familyName")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("givenName")
    public String getGivenName() {
        return givenName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("givenName")
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 
     */
    @JsonProperty("dateOfDeath")
    public String getDateOfDeath() {
        return dateOfDeath;
    }

    /**
     * 
     */
    @JsonProperty("dateOfDeath")
    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
