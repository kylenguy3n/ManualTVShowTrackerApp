package ui;

import model.TelevisionEpisode;
import model.TelevisionSeason;
import model.TelevisionShow;
import model.TelevisionShowList;

import java.util.List;
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

    // MODIFIES: this
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

    // EFFECTS: displays main menu options for user to choose
    private void displayMainMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) Access 'Plan to Watch' list");
        System.out.println("\t(2) Access 'Currently Watching' list");
        System.out.println("\t(3) Access 'Completed' list");
        System.out.println("\t(4) Access 'Favourite Shows' list");
        System.out.println("\t(5) Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user input at the main menu
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
            invalidKey();
        }
    }

    // MODIFIES: this
    // EFFECTS: accesses and displays 'Plan to Watch' list menu and processes user input at the submenu
    private void accessPlanToWatch() {
        System.out.println("\n'" + planToWatchList.getListName() + "' list");
        processSubMenuKeyCommand(1);
    }

    // MODIFIES: this
    // EFFECTS: accesses and displays 'Currently Watching' list menu and processes user input at the submenu
    private void accessCurrentlyWatching() {
        System.out.println("\n'" + currentlyWatchingList.getListName() + "' list");
        processSubMenuKeyCommand(2);
    }

    // MODIFIES: this
    // EFFECTS: accesses and displays 'Completed' list menu and processes user input at the submenu
    private void accessCompleted() {
        System.out.println("\n'" + completedList.getListName() + "' list");
        processSubMenuKeyCommand(3);
    }

    // MODIFIES: this
    // EFFECTS: accesses and displays 'Favourite Shows' list menu and processes user input at the submenu
    private void accessFavouriteShows() {
        System.out.println("\n'" + favouriteShowsList.getListName() + "' list");
        processSubMenuKeyCommand(4);
    }

    // MODIFIES: this
    // EFFECTS: displays and processes user input at the submenu
    private void processSubMenuKeyCommand(int whichList) {
        displaySubMenu();

        switch (keyCommand()) {
            case "1":
                printWhichTelevisionList(whichList);
                break;
            case "2":
                addShowSetup(whichList);
                break;
            case "3":
                removeShow(whichList);
                break;
            case "4":
                rateShow(whichList);
                break;
//            case "5":
//                // STUB // TODO
//                break;
            case "6":
                break;
            default:
                invalidKey();
                processSubMenuKeyCommand(whichList);
        }
    }

    // EFFECTS: displays submenu options for user to choose
    private void displaySubMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) View list");
        System.out.println("\t(2) Add new show to list");
        System.out.println("\t(3) Remove show from list");
        System.out.println("\t(4) Rate show from list");
//        System.out.println("\t(5) Move or copy show to a different list"); // TODO
        System.out.println("\t(6) Go back to main menu");
    }

    // EFFECTS: selects the desired television list to print the shows in its list
    private void printWhichTelevisionList(int whichList) {
        System.out.println("\nStart of list");
        System.out.println("---------------------------------------------");
        if (whichList == 1) {
            List<TelevisionShow> rightList = planToWatchList.getTelevisionShowList();
            printTelevisionList(rightList);
        } else if (whichList == 2) {
            List<TelevisionShow> rightList = currentlyWatchingList.getTelevisionShowList();
            printTelevisionList(rightList);
        } else if (whichList == 3) {
            List<TelevisionShow> rightList = completedList.getTelevisionShowList();
            printTelevisionList(rightList);
        } else if (whichList == 4) {
            List<TelevisionShow> rightList = favouriteShowsList.getTelevisionShowList();
            printTelevisionList(rightList);
        }
        System.out.println("---------------------------------------------");
        System.out.println("End of list");
    }

    // EFFECTS: prints out the television list show by show
    private void printTelevisionList(List<TelevisionShow> rightList) {
        for (TelevisionShow show : rightList) {
            System.out.println(show.getTitle());
        }
    }

    // MODIFIES: this
    // EFFECTS: makes user construct the television show that is then added to the desired television list
    private void addShowSetup(int whichList) {
        System.out.println("\nAdd new show:");
        System.out.println("Please enter the name of the show");
        TelevisionShow show = new TelevisionShow(keyCommand());
        setupShowSeasons(show);
        showDescriptionAdder(show);
        addShowToWhichList(show, whichList);
        System.out.println("\n'" + show.getTitle() + "' has been added to the list");
    }

    // MODIFIES: TelevisionShow
    // EFFECTS: assigns number of seasons to add to the television show
    private void setupShowSeasons(TelevisionShow show) {
        System.out.println("\nHow many seasons are in this show?");
        int numberOfSeasons = Integer.parseInt(keyCommand());

        if (numberOfSeasons <= 0) {
            invalidKey();
            setupShowSeasons(show);
        } else {
            for (int i = 1; i <= numberOfSeasons; i++) {
                TelevisionSeason season = new TelevisionSeason(i, "Season " + Integer.toString(i));
                show.addSeasonToShow(season);
                setupSeasonEpisodes(season, i);
            }
        }
    }

    // MODIFIES: TelevisionSeason
    // EFFECTS: assigns number of episodes to add to the television season
    private void setupSeasonEpisodes(TelevisionSeason season, int i) {
        System.out.println("\nHow many episodes are in season " + Integer.toString(i) + "?");
        int numberOfEpisodes = Integer.parseInt(keyCommand());

        if (numberOfEpisodes <= 0) {
            invalidKey();
            setupSeasonEpisodes(season, i);
        } else {
            for (int j = 1; j <= numberOfEpisodes; j++) {
                TelevisionEpisode episode = new TelevisionEpisode(j, "Episode " + Integer.toString(j));
                season.addEpisodeToSeason(episode);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the instantiated show to the desired television list
    private void addShowToWhichList(TelevisionShow show, int whichList) {
        switch (whichList) {
            case 1:
                this.planToWatchList.addShowToList(show);
                break;
            case 2:
                this.currentlyWatchingList.addShowToList(show);
                break;
            case 3:
                this.completedList.addShowToList(show);
                break;
            case 4:
                this.favouriteShowsList.addShowToList(show);
                break;
        }
    }

    // MODIFIES: TelevisionShow
    // EFFECTS: provides user options to add a description to the recently added television show
    private void showDescriptionAdder(TelevisionShow show) {
        showDescriptionAdderMenu();

        switch (keyCommand()) {
            case "1":
                System.out.println("\nType in the show's description:");
                show.setDescription(keyCommand());
                System.out.println("\nThe show's description has been set");
                break;
            case "2":
                break;
            default:
                invalidKey();
                showDescriptionAdder(show);
        }
    }

    // EFFECTS: displays options for choosing to add a description to the recently added television show
    private void showDescriptionAdderMenu() {
        System.out.println("\nDo you want to add a description for this show?");
        System.out.println("---------------------------------------------");
        System.out.println("(1) Yes");
        System.out.println("(2) No");
    }

    // MODIFIES: this
    // EFFECTS:
    private void removeShow(int whichList) {
        // STUB
    }

    // MODIFIES: this
    // EFFECTS:
    private void rateShow(int whichList) {

    }

    // EFFECTS: prints a message when an invalid key command is inputted
    private void invalidKey() {
        System.out.println("\nYou have not entered a valid option. Please try again.");
    }

    // EFFECTS: returns user input as a string upon pressing the enter key
    private String keyCommand() {
        return input.nextLine();
    }

}
