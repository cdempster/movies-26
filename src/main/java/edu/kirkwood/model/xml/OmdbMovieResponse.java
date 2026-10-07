package edu.kirkwood.model.xml;

import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * This represents the root tag from the OMDBApi XML
 * <root totalResults="530" response="True">
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD) // Tells JAXB to use fields directly
public class OmdbMovieResponse {

    @XmlElement(name = "result")
    private List<MovieSearchResult> searchResults;

    @XmlAttribute(name = "totalResults")
    private int totalResults;

    @XmlAttribute(name = "response")
    private String response;

    public List<MovieSearchResult> getSearchResults() {
        return searchResults;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }
}
