package ui;

import model.*;
import persistence.FileReader;
import persistence.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Television tracker application
public class TelevisionTrackerConsole {
    private static final String SAVED_FILE_DIR = "./data/savedTelevisionShowLists.json";
    private TelevisionShowList planToWatchList;
    private TelevisionShowList currentlyWatchingList;
    private TelevisionShowList completedList;
    private TelevisionShowList favouriteShowsList;
    private Scanner input;
    private FileReader fileReader;
    private FileWriter fileWriter;

    // EFFECTS: initializes television show lists and runs the television tracker application
    public TelevisionTrackerConsole() throws FileNotFoundException {
        planToWatchList = new TelevisionShowList("Plan to Watch");
        currentlyWatchingList = new TelevisionShowList("Currently Watching");
        completedList = new TelevisionShowList("Completed");
        favouriteShowsList = new TelevisionShowList("Favourite Shows");
        input = new Scanner(System.in);
        fileWriter = new FileWriter(SAVED_FILE_DIR);
        fileReader = new FileReader(SAVED_FILE_DIR);

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

            if (menuKeyCommand.equals("7")) {
                keepRunning = false;
            } else {
                processMenuKeyCommand(menuKeyCommand);
            }
        }
        System.out.println("\nYou have exited the application.\n");
    }

    // EFFECTS: displays main menu options for user to choose
    private void displayMainMenu() {
        System.out.println("\nPlease choose one of the following options:");
        System.out.println("---------------------------------------------");
        System.out.println("\t(1) Access 'Plan to Watch' list");
        System.out.println("\t(2) Access 'Currently Watching' list");
        System.out.println("\t(3) Access 'Completed' list");
        System.out.println("\t(4) Access 'Favourite Shows' list");
        System.out.println("\t(5) Save all lists to a file");
        System.out.println("\t(6) Load all lists from an existing file");
        System.out.println("\t(7) Quit");
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
        } else if (menuKeyCommand.equals("5")) {
            saveTelevisionShowLists();
        } else if (menuKeyCommand.equals("6")) {
            loadTelevisionShowLists();
        } else {
            invalidKey();
        }
    }

    // EFFECTS: accesses and displays 'Plan to Watch' list menu and processes user input at the submenu
    private void accessPlanToWatch() {
        System.out.println("\n'" + planToWatchList.getListName() + "' list");
        processSubMenuKeyCommand(1);
    }

    // EFFECTS: accesses and displays 'Currently Watching' list menu and processes user input at the submenu
    private void accessCurrentlyWatching() {
        System.out.println("\n'" + currentlyWatchingList.getListName() + "' list");
        processSubMenuKeyCommand(2);
    }

    // EFFECTS: accesses and displays 'Completed' list menu and processes user input at the submenu
    private void accessCompleted() {
        System.out.println("\n'" + completedList.getListName() + "' list");
        processSubMenuKeyCommand(3);
    }

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
                removeShowSetup(whichList);
                break;
            case "4":
                rateShowSetup(whichList);
                break;
            case "5":
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
        System.out.println("\t(5) Go back to main menu");
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

    // EFFECTS: prints out the entire television list show by show
    private void printTelevisionList(List<TelevisionShow> rightList) {
        for (TelevisionShow show : rightList) {
            System.out.println(show.getTitle());
        }
    }

    // MODIFIES: this
    // EFFECTS: makes user construct the television show that is then added to the desired television list
    private void addShowSetup(int whichList) {
        System.out.println("\nWhat show would you like to add to this list?");
        System.out.println("Please enter the name of the show:");
        TelevisionShow show = new TelevisionShow(keyCommand());
        setupShowSeasons(show);
        showDescriptionAdder(show);
        addShowToWhichList(show, whichList);
        System.out.println("\n'" + show.getTitle() + "' has been added to the list.");
    }

    // MODIFIES: show
    // EFFECTS: assigns number of seasons to add to the television show
    private void setupShowSeasons(TelevisionShow show) {
        System.out.println("\nHow many seasons are in this show?");
        String numberOfSeasons = keyCommand();

        if (Integer.parseInt(numberOfSeasons) <= 0) {
            invalidKey();
            setupShowSeasons(show);
        } else {
            for (int i = 1; i <= Integer.parseInt(numberOfSeasons); i++) {
                TelevisionSeason season = new TelevisionSeason(i, "Season " + Integer.toString(i));
                show.addSeasonToShow(season);
                setupSeasonEpisodes(season, i);
            }
        }
    }

    // MODIFIES: season
    // EFFECTS: assigns number of episodes to add to the television season
    private void setupSeasonEpisodes(TelevisionSeason season, int i) {
        System.out.println("\nHow many episodes are in season " + Integer.toString(i) + "?");
        String numberOfEpisodes = keyCommand();

        if (Integer.parseInt(numberOfEpisodes) <= 0) {
            invalidKey();
            setupSeasonEpisodes(season, i);
        } else {
            for (int j = 1; j <= Integer.parseInt(numberOfEpisodes); j++) {
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
            default:
                this.favouriteShowsList.addShowToList(show);
                break;
        }
    }

    // MODIFIES: TelevisionShow
    // EFFECTS: provides user options to add a description to the recently added television show
    private void showDescriptionAdder(TelevisionShow show) {
        displayShowDescriptionAdderMenu();

        switch (keyCommand()) {
            case "1":
                System.out.println("\nType in the show's description:");
                show.setDescription(keyCommand());
                System.out.println("\nThe show's description has been set.");
                break;
            case "2":
                System.out.println("\nThe show's description will be set as empty.");
                break;
            default:
                invalidKey();
                showDescriptionAdder(show);
        }
    }

    // EFFECTS: displays options for choosing to add a description to the recently added television show
    private void displayShowDescriptionAdderMenu() {
        System.out.println("\nDo you want to add a description for this show?");
        System.out.println("---------------------------------------------");
        System.out.println("(1) Yes");
        System.out.println("(2) No");
    }

    // EFFECTS: displays and processes input to remove television show from desired list
    private void removeShowSetup(int whichList) {
        System.out.println("\nWhich show would you like to remove from this list?");
        System.out.println("\nEnter the number in front of the show you would like to remove:");
        System.out.println("---------------------------------------------");
        selectWhichTelevisionList(whichList);
        System.out.println("(0) to return to menu");
        removeFromCorrectList(whichList);
    }

    // EFFECTS: selects which list to obtain shows from to display for menu options for removing a show
    private void removeFromCorrectList(int whichList) {
        if (whichList == 1) {
            TelevisionShowList correctRemoveList = planToWatchList;
            removeShow(correctRemoveList);
        } else if (whichList == 2) {
            TelevisionShowList correctRemoveList = currentlyWatchingList;
            removeShow(correctRemoveList);
        } else if (whichList == 3) {
            TelevisionShowList correctRemoveList = completedList;
            removeShow(correctRemoveList);
        } else if (whichList == 4) {
            TelevisionShowList correctRemoveList = favouriteShowsList;
            removeShow(correctRemoveList);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes show from list via its index inputted
    private void removeShow(TelevisionShowList correctRemoveList) {
        String removeNumberInput = keyCommand();
        if (Integer.parseInt(removeNumberInput) == 0) {
            return;
        } else if (Integer.parseInt(removeNumberInput) != 0) {
            int showIndex = Integer.parseInt(removeNumberInput) - 1;
            TelevisionShow show = correctRemoveList.getTelevisionShowList().get(showIndex);
            correctRemoveList.removeShowFromList(show);
            System.out.println("\nThe show has been removed");
        }
    }

    // EFFECTS: displays and processes input to rate television show from desired list
    private void rateShowSetup(int whichList) {
        System.out.println("\nWhich show would you like to rate in this list?");
        System.out.println("\nEnter the number in front of the show you would like to rate:");
        System.out.println("---------------------------------------------");
        selectWhichTelevisionList(whichList);
        System.out.println("(0) to return to menu");
        rateFromCorrectList(whichList);
    }

    // EFFECTS: selects which list to obtain shows from to display for menu options for rating a show
    private void rateFromCorrectList(int whichList) {
        if (whichList == 1) {
            List<TelevisionShow> correctRateList = planToWatchList.getTelevisionShowList();
            rateShow(correctRateList);
        } else if (whichList == 2) {
            List<TelevisionShow> correctRateList = currentlyWatchingList.getTelevisionShowList();
            rateShow(correctRateList);
        } else if (whichList == 3) {
            List<TelevisionShow> correctRateList = completedList.getTelevisionShowList();
            rateShow(correctRateList);
        } else if (whichList == 4) {
            List<TelevisionShow> correctRateList = favouriteShowsList.getTelevisionShowList();
            rateShow(correctRateList);
        }
    }

    // MODIFIES: TelevisionShow
    // EFFECTS: rates show from list via its index inputted and rating number
    private void rateShow(List<TelevisionShow> correctRateList) {
        String showNumberInput = keyCommand();
        if (Integer.parseInt(showNumberInput) == 0) {
            return;
        } else if (Integer.parseInt(showNumberInput) != 0) {
            TelevisionShow obtainedShow = correctRateList.get(Integer.parseInt(showNumberInput) - 1);
            System.out.println("\nAssign a rating between 1 to 10 (set 0 for n/a)");
            String rateNumberInput = keyCommand();
            if (Integer.parseInt(rateNumberInput) < 0 || Integer.parseInt(rateNumberInput) > 10) {
                invalidKey();
            } else {
                obtainedShow.setRating(Integer.parseInt(rateNumberInput));
                System.out.println("\nThe show has been rated");
            }
        }
    }

    // EFFECTS: selects which list to obtain shows from to display for menu options
    private void selectWhichTelevisionList(int whichList) {
        if (whichList == 1) {
            List<TelevisionShow> displayList = planToWatchList.getTelevisionShowList();
            displayTelevisionListIndexMenu(displayList);
        } else if (whichList == 2) {
            List<TelevisionShow> displayList = currentlyWatchingList.getTelevisionShowList();
            displayTelevisionListIndexMenu(displayList);
        } else if (whichList == 3) {
            List<TelevisionShow> displayList = completedList.getTelevisionShowList();
            displayTelevisionListIndexMenu(displayList);
        } else if (whichList == 4) {
            List<TelevisionShow> displayList = favouriteShowsList.getTelevisionShowList();
            displayTelevisionListIndexMenu(displayList);
        }
    }

    // EFFECTS: displays the index and name of all shows in the television list for user to choose
    private void displayTelevisionListIndexMenu(List<TelevisionShow> displayList) {
        for (TelevisionShow show : displayList) {
            System.out.println("(" + (displayList.indexOf(show) + 1) + ") " + show.getTitle());
        }
    }

    // EFFECTS: prints a message when an invalid key command is inputted
    private void invalidKey() {
        System.out.println("\nYou have not entered a valid option. Please try again.");
    }

    // MODIFIES: this
    // EFFECTS: returns user input as a string upon pressing the enter key
    private String keyCommand() {
        return input.nextLine();
    }

    // EFFECTS: saves the television show lists to file
    private void saveTelevisionShowLists() {
        try {
            ListOfTelevisionShowLists saveListOfLists = new ListOfTelevisionShowLists();
            saveListOfLists.addTelevisionShowListToList(planToWatchList);
            saveListOfLists.addTelevisionShowListToList(currentlyWatchingList);
            saveListOfLists.addTelevisionShowListToList(completedList);
            saveListOfLists.addTelevisionShowListToList(favouriteShowsList);

            fileWriter.openFile();
            fileWriter.writeFile(saveListOfLists);
            fileWriter.closeFile();

            System.out.println("Saved " + planToWatchList.getListName() + " to " + SAVED_FILE_DIR);
            System.out.println("Saved " + currentlyWatchingList.getListName() + " to " + SAVED_FILE_DIR);
            System.out.println("Saved " + completedList.getListName() + " to " + SAVED_FILE_DIR);
            System.out.println("Saved " + favouriteShowsList.getListName() + " to " + SAVED_FILE_DIR);
        } catch (FileNotFoundException e) {
            System.out.println("\nError: Unable to save data to file: " + SAVED_FILE_DIR);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the television show lists from saved file
    private void loadTelevisionShowLists() {
        try {
            ListOfTelevisionShowLists loadListOfLists = fileReader.readFile();
            planToWatchList = loadListOfLists.getListOfTelevisionShowLists().get(0);
            currentlyWatchingList = loadListOfLists.getListOfTelevisionShowLists().get(1);
            completedList = loadListOfLists.getListOfTelevisionShowLists().get(2);
            favouriteShowsList = loadListOfLists.getListOfTelevisionShowLists().get(3);
            System.out.println("Loaded " + planToWatchList.getListName() + " from " + SAVED_FILE_DIR);
            System.out.println("Loaded " + currentlyWatchingList.getListName() + " from " + SAVED_FILE_DIR);
            System.out.println("Loaded " + completedList.getListName() + " from " + SAVED_FILE_DIR);
            System.out.println("Loaded " + favouriteShowsList.getListName() + " from " + SAVED_FILE_DIR);
        } catch (IOException e) {
            System.out.println("\nUnable to load data from file: " + SAVED_FILE_DIR);
        }
    }
}
