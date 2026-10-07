package edu.kirkwood;

import edu.kirkwood.dao.MovieDAO;
import edu.kirkwood.dao.MovieDAOFactory;
import edu.kirkwood.dao.XmlMovieDAO;
import edu.kirkwood.model.xml.MovieSearchResult;

import java.util.List;

public class Main {
    static void main() {
        MovieDAO movieDAO = MovieDAOFactory.getMovieDAO();
        String searchTitle = "Batman"; // TODO: Implement the UserInput class
        if(movieDAO instanceof XmlMovieDAO){
            XmlMovieDAO xmlMovieDAO = (XmlMovieDAO) movieDAO;
            List<MovieSearchResult> results = xmlMovieDAO.search(searchTitle);
            System.out.println("Found " + results.size() + " results for '" + searchTitle + "'.");
            results.forEach(System.out::println);
        }
    }
}
