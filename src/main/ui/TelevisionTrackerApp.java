package ui;

import model.TelevisionShowList;

import java.util.Scanner;

// Television tracker application
public class TelevisionTrackerApp {
    private TelevisionShowList planToWatchList;
    private TelevisionShowList currentlyWatchingList;
    private TelevisionShowList completedList;
    private TelevisionShowList favouriteShowsList;
    private Scanner input;

    // EFFECTS: initializes television show lists and runs the television tracker application
    public TelevisionTrackerApp() {
        planToWatchList = new TelevisionShowList("Plan to Watch");
        currentlyWatchingList = new TelevisionShowList("Currently Watching");
        completedList = new TelevisionShowList("Completed");
        favouriteShowsList = new TelevisionShowList("Favourite Shows");
        input = new Scanner(System.in);

        runTelevisionApp();
    }

    // EFFECTS: displays welcome message and processes user input at the main menu
    public void runTelevisionApp() {
        boolean keepRunning = true;
        String keyCommand = null;

        System.out.println("\nWelcome to the Television Tracker Application.");

        while (keepRunning) {
            displayMainMenu();
            keyCommand = input.nextLine();

            if (keyCommand.equals("5")) {
                keepRunning = false;
            } else {
                processKeyCommand(keyCommand);
            }
        }
        System.out.println("\nYou have exited the application.");
    }

    // EFFECTS: displays menu options for user to choose
    private void displayMainMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) Access 'Plan to Watch' list");
        System.out.println("\t(2) Access 'Currently Watching' list");
        System.out.println("\t(3) Access 'Completed' list");
        System.out.println("\t(4) Access 'Favourite Shows' list");
        System.out.println("\t(5) Quit");
    }

    // EFFECTS: processes user input at main menu
    private void processKeyCommand(String keyCommand) {
        if (keyCommand.equals("1")) {
            accessPlanToWatch();
        } else if (keyCommand.equals("2")) {
            accessCurrentlyWatching();
        } else if (keyCommand.equals("3")) {
            accessCompleted();
        } else if (keyCommand.equals("4")) {
            accessFavouriteShows();
        } else {
            invalidButton();
        }
    }

    // EFFECTS:
    private void accessPlanToWatch() {
        System.out.println("\n'Plan to Watch' list");
        // STUB
    }

    // EFFECTS:
    private void accessCurrentlyWatching() {
        System.out.println("\n'Currently Watching' list");
        // STUB
    }

    // EFFECTS:
    private void accessCompleted() {
        System.out.println("\n'Completed' list");
        // STUB
    }

    // EFFECTS:
    private void accessFavouriteShows() {
        System.out.println("\n'Favourite Shows' list");
        // STUB
    }



    // EFFECTS:
    private void displaySubMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) View list");
        System.out.println("\t(2) Add new show to list");
        System.out.println("\t(3) Remove show from list");
        System.out.println("\t(4) Copy show to different list");
        System.out.println("\t(5) Move show to different list");
    }

    private void invalidButton() {
        System.out.println("You have not entered a valid option. Please try again.");
    }
}
