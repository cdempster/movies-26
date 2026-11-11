package edu.kirkwood.view;

import static edu.kirkwood.view.UIUtility.printMenu;
import static edu.kirkwood.view.UserInput.getInt;

public class MainMenu {

    /**
     * Displays the main menu and processes selections until the user quits.
     */
    public static void show() {
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
                    // Navigate to Movies section
                    break;
                case 2:
                    // Navigate to Dahlias section
                    break;
                default:
                    // Quit
                    return;
            } // end switch
        } // end loop
    } // end show method
}