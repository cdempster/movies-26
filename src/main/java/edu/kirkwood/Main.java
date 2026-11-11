package edu.kirkwood;

import edu.kirkwood.dao.json.JsonMovieDAO;
import edu.kirkwood.dao.MovieDAO;
import edu.kirkwood.dao.MovieDAOFactory;
import edu.kirkwood.dao.xml.XmlMovieDAO;
import edu.kirkwood.view.Animator;

import java.util.List;

public class Main {
    static void main() throws InterruptedException {
        MovieDAO movieDAO = MovieDAOFactory.getMovieDAO();
        String searchTitle = "Batman"; // Prompt the user for their search
        Animator animator = new Animator("Loading movies, please wait");
        Thread animatorThread = new Thread(animator);
        animatorThread.start();
        Thread.sleep(3000);
        if(movieDAO instanceof XmlMovieDAO){
            XmlMovieDAO xmlMovieDAO = (XmlMovieDAO) movieDAO;
            List<edu.kirkwood.model.xml.MovieSearchResult> results = xmlMovieDAO.search(searchTitle);
            animatorThread.interrupt();
            results.forEach(System.out::println);
        } else if(movieDAO instanceof JsonMovieDAO) {
            JsonMovieDAO jsonMovieDAO = (JsonMovieDAO) movieDAO;
            List<edu.kirkwood.model.json.MovieSearchResult> results = jsonMovieDAO.search(searchTitle);
            animatorThread.interrupt();
            results.forEach(System.out::println);
        }
    }
}
