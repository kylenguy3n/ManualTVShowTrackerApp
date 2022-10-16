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

    // NOTE: will change menuKeyCommand primitive to using the keyCommand() method in the future
    // EFFECTS: displays welcome message and processes user input at the main menu
    private void runTelevisionApp() {
        boolean keepRunning = true;
        String menuKeyCommand = null;

        System.out.println("\nWelcome to the Television Tracker Application.");

        while (keepRunning) {
            displayMainMenu();
            menuKeyCommand = input.nextLine();

            if (menuKeyCommand.equals("5")) {
                keepRunning = false;
            } else {
                processMenuKeyCommand(menuKeyCommand);
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
    private void processMenuKeyCommand(String menuKeyCommand) {
        if (menuKeyCommand.equals("1")) {
            accessPlanToWatch();
        } else if (menuKeyCommand.equals("2")) {
            accessCurrentlyWatching();
        } else if (menuKeyCommand.equals("3")) {
            accessCompleted();
        } else if (menuKeyCommand.equals("4")) {
            accessFavouriteShows();
        } else {
            invalidButton();
        }
    }

    // EFFECTS: accesses and displays Plan to Watch list menu and processes user input at the submenu
    private void accessPlanToWatch() {
        System.out.println("\n'Plan to Watch' list");
        processSubMenuKeyCommand(1);
    }

    // EFFECTS: accesses and displays Currently Watching list menu and processes user input at the submenu
    private void accessCurrentlyWatching() {
        System.out.println("\n'Currently Watching' list");
        processSubMenuKeyCommand(2);
    }

    // EFFECTS: accesses and displays Completed list menu and processes user input at the submenu
    private void accessCompleted() {
        System.out.println("\n'Completed' list");
        processSubMenuKeyCommand(3);
    }

    // EFFECTS: accesses and displays Favourite Shows list menu and processes user input at the submenu
    private void accessFavouriteShows() {
        System.out.println("\n'Favourite Shows' list");
        processSubMenuKeyCommand(4);
    }

    // EFFECTS: displays submenu options for user to choose
    private void displaySubMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) View list");
        System.out.println("\t(2) Add new show to list");
        System.out.println("\t(3) Remove show from list");
//        System.out.println("\t(4) Copy show to different list");
//        System.out.println("\t(5) Move show to different list");
    }

    // EFFECTS: processes user input at main menu
    private void processSubMenuKeyCommand(int whichList) {
        displaySubMenu();
        switch (keyCommand()) {
            case "1":
                printWhichTelevisionList(whichList);
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            default:
                invalidButton();
        }
    }

    private void printWhichTelevisionList(int whichList) {
        switch (whichList) {
            case 1:
                System.out.println(planToWatchList.getTelevisionShowList());
                break;
            case 2:
                System.out.println((currentlyWatchingList.getTelevisionShowList()));
                break;
            case 3:
                System.out.println(completedList.getTelevisionShowList());
                break;
            case 4:
                System.out.println((favouriteShowsList.getTelevisionShowList()));
                break;
        }
    }

    private void invalidButton() {
        System.out.println("You have not entered a valid option. Please try again.");
    }

    // EFFECTS: returns user input
    private String keyCommand() {
        return input.nextLine();
    }

}
