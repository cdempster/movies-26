package edu.kirkwood;

import edu.kirkwood.dao.JsonMovieDAO;
import edu.kirkwood.dao.MovieDAO;
import edu.kirkwood.dao.MovieDAOFactory;
import edu.kirkwood.dao.XmlMovieDAO;

import java.util.List;

public class Main {
    static void main() {
        MovieDAO movieDAO = MovieDAOFactory.getMovieDAO();
        String searchTitle = "Batman"; // TODO: Implement the UserInput class
        if(movieDAO instanceof XmlMovieDAO){
            XmlMovieDAO xmlMovieDAO = (XmlMovieDAO) movieDAO;
            List<edu.kirkwood.model.xml.MovieSearchResult> results = xmlMovieDAO.search(searchTitle);
            System.out.println("Found " + results.size() + " results for '" + searchTitle + "'.");
            results.forEach(System.out::println);
        } else if(movieDAO instanceof JsonMovieDAO) {
            JsonMovieDAO jsonMovieDAO = (JsonMovieDAO) movieDAO;
            List<edu.kirkwood.model.json.MovieSearchResult> results = jsonMovieDAO.search(searchTitle);
            System.out.println("Found " + results.size() + " results for '" + searchTitle + "'.");
            results.forEach(System.out::println);
        }
    }
}
