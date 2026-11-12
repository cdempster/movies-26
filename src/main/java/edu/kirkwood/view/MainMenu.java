package edu.kirkwood.view;

import edu.kirkwood.dao.sql.SQLDahliaDAO;
import edu.kirkwood.dao.sql.SQLMovieDAO;
import edu.kirkwood.model.sql.DahliaEntity;

import java.util.List;

import static edu.kirkwood.view.UIUtility.pressEnterToContinue;
import static edu.kirkwood.view.UIUtility.printMenu;
import static edu.kirkwood.view.UserInput.getInt;
import static edu.kirkwood.view.UserInput.getString;

public class MainMenu {

    /**
     * Displays the main menu and processes selections until the user quits.
     */
    public static void show(SQLMovieDAO movieDAO, SQLDahliaDAO dahliaDAO) {
        String[] menuItems = {
                "Movies",
                "Dahlias",
                "Quit"
        };
        while(true) {
            printMenu("Main Menu", menuItems);
            int choice = getInt("What would you like to search for?", true, 1, menuItems.length);
            switch(choice) {
                case 1:
                    MainMenu.show(movieDAO);
                    break;
                case 2:
                    MainMenu.show(dahliaDAO);
                    break;
                default:
                    // Quit
                    return;
            } // end switch
        } // end loop
    } // end show method

    public static void show(SQLMovieDAO movieDAO){
        String title = edu.kirkwood.view.UserInput.getString("Enter the movie title to search for: ");
        java.util.List<edu.kirkwood.model.sql.MovieEntity> movies = movieDAO.search(title);
        if(movies.isEmpty()){
            System.out.println("No movies found containing '" + title + "' in the title.");
        } else {
            movies.forEach(System.out::println);
        }
        pressEnterToContinue();
    }

    public static void show(SQLDahliaDAO dahliaDAO) {
        String varietyName = getString("Enter the dahlia variety name to search for: ");
        List<DahliaEntity> dahliaVarieties = dahliaDAO.search(varietyName);
        if(dahliaVarieties.isEmpty()) {
            System.out.println("No dahlia varieties found containing '" + varietyName + "' in the variety name.");
        } else {
            dahliaVarieties.forEach(System.out::println);
        }
        pressEnterToContinue();
    }
}