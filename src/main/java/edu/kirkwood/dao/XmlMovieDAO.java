package edu.kirkwood.dao;

import edu.kirkwood.model.xml.MovieSearchResult;
import edu.kirkwood.model.xml.OmdbMovieResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class XmlMovieDAO implements MovieDAO<MovieSearchResult> {
    private String url;

    public XmlMovieDAO(String url){
        this.url = url;
    }

    /**
     * Find a single movie by its unique ID
     *
     * @param id The ID of the movie to find
     * @return The single movie object, or null if not found
     */
    @Override
    public MovieSearchResult findById(String id) {
        System.out.println("Fetching movie " + id + " from XML...");
        return null;
    }

    /**
     * Retrieves all movies from the data source that match the title
     *
     * @param title The title of the movie
     * @return A list of all movies that match the title
     */
    @Override
    public List<MovieSearchResult> search(String title) {
        System.out.println("Searching for " + title + " from XML...");

        if(url == null) {
            throw new IllegalArgumentException("XML API URL is not configured in application.properties");
        }
        String encodeSearchTerm = URLEncoder.encode(title, StandardCharsets.UTF_8);
        url = String.format("%s%s&page=1", url, encodeSearchTerm);

        try {
            HttpRequest request  = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return parseXml(response.body()); // response.body() is the raw XML
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    /**
     * Logic to parse the entire XML file and return it as a List of movies
     * @param xml The raw XML data
     * @return A list of movies
     */
    public List<MovieSearchResult> parseXml(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OmdbMovieResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        OmdbMovieResponse movieResponse = (OmdbMovieResponse) unmarshaller.unmarshal(reader);
        return movieResponse.getSearchResults() != null ? movieResponse.getSearchResults() : Collections.emptyList();
    }
}
