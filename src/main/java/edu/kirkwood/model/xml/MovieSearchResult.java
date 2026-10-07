package edu.kirkwood.model.xml;

import jakarta.xml.bind.annotation.*; // For JAXB
// import com.fasterxml.jackson.data.format.xml.annotation.*; // For Jackson

/**
 * This class represents a single result tag from the OMDBApi in XML format
 * <result
 *      title="Batman Begins"
 *      year="2005"
 *      imdbID="tt0372784"
 *      type="movie"
 *      poster="https://m.media-amazon.com/images/M/MV5BMzA2NDQzZDEtNDU5Ni00YTlkLTg2OWEtYmQwM2Y1YTBjMjFjXkEyXkFqcGc@._V1_QL75_UX380_CR0,0,380,562_.jpg"
 *  />
 */
@XmlAccessorType(XmlAccessType.FIELD) // Tells JAXB to use fields directly
public class MovieSearchResult {

    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "year")
    private String year;

    @XmlAttribute(name = "imdbID")
    private String imdbID;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "MovieSearchResult{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
