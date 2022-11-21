package ui.gui;

import model.ListOfTelevisionShowLists;
import model.TelevisionShowList;
import ui.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Creates the GUI screen for the TV Tracker application
public class GUI {
    private FileManager fileManager;
    private ListOfTelevisionShowLists listOfTVShowLists;

    private JFrame frame;
    private JTabbedPane tabbedPane;

    private MainMenuPanel mainMenuPanel;
    private PlanToWatchPanel planToWatchPanel;
    private CurrentlyWatchingPanel currentlyWatchingPanel;
    private CompletedPanel completedPanel;
    private FavouriteShowsPanel favouriteShowsPanel;

    // EFFECTS: initializes the program GUI
    public GUI() {
        fileManager = new FileManager();
        setUpListOfTVShowLists();
        setUpFrame();
        mainMenuPanel = new MainMenuPanel(this);
        setUpTVListPanels();
        setUpTabbedPane();
    }

    // MODIFIES: this
    // EFFECTS: sets up list of TV show lists and adds the 4 types of TV lists in the application to it
    public void setUpListOfTVShowLists() {
        this.listOfTVShowLists = new ListOfTelevisionShowLists();
        TelevisionShowList planToWatchList = new TelevisionShowList("Plan to Watch");
        TelevisionShowList currentlyWatchingList = new TelevisionShowList("Currently Watching");
        TelevisionShowList completedList = new TelevisionShowList("Completed");
        TelevisionShowList favouriteShowsList = new TelevisionShowList("Favourite Shows");
        listOfTVShowLists.addTelevisionShowListToList(planToWatchList);
        listOfTVShowLists.addTelevisionShowListToList(currentlyWatchingList);
        listOfTVShowLists.addTelevisionShowListToList(completedList);
        listOfTVShowLists.addTelevisionShowListToList(favouriteShowsList);
    }

    // MODIFIES: this
    // EFFECTS: sets up JFrame for the TV Tracker GUI
    private void setUpFrame() {
        frame = new JFrame("Television Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 800);
        Image icon = Toolkit.getDefaultToolkit().getImage("data/images/Icon.png");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
    }

    // EFFECTS: sets up each JPanels for each of the TV show lists
    private void setUpTVListPanels() {
        planToWatchPanel = new PlanToWatchPanel(this);
        currentlyWatchingPanel = new CurrentlyWatchingPanel(this);
        completedPanel = new CompletedPanel(this);
        favouriteShowsPanel = new FavouriteShowsPanel(this);
    }

    // MODIFIES: this
    // EFFECTS: sets up JTabbedPane side pane for the TV Tracker GUI a main menu option and option for all TV lists
    private void setUpTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(SwingConstants.LEFT);

        tabbedPane.addTab("Main Menu", mainMenuPanel);
        tabbedPane.addTab("Plan to Watch", planToWatchPanel);
        tabbedPane.addTab("Currently Watching", currentlyWatchingPanel);
        tabbedPane.addTab("Completed", completedPanel);
        tabbedPane.addTab("Favourite Shows", favouriteShowsPanel);
        Container contentPane = frame.getContentPane();
        contentPane.add(tabbedPane);
    }

    // MODIFIES: this
    // EFFECTS: passes the data in the list of TV Show lists in GUI to the file manager to save to file;
    //          catches IOException if it cannot load data and displays and error message
    public void saveData() {
        try {
            fileManager.overwrite(listOfTVShowLists);
            fileManager.saveFile();
            JOptionPane.showMessageDialog(null, "TV list data has been successfully saved.",
                    "Save Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to save data to file.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads read data from file manager into the list of TV Show Lists in the GUI;
    //          catches IOException if it cannot load data and displays and error message
    public void loadData() {
        try {
            fileManager.loadFile();
            this.listOfTVShowLists = fileManager.getListOfTelevisionShowLists();
            JOptionPane.showMessageDialog(null, "TV list data has been successfully loaded.",
                    "Load Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to load last saved data from file.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        tabbedPaneRefresh();
    }

    // MODIFIES: this
    // EFFECTS: clears data with appropriate warnings to confirm clearing the data
    //          by re-initializing via setUpListOfTVShowLists
    public void clearData() {
        int input = JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to clear the data?", "Warning!",
                JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            setUpListOfTVShowLists();
            JOptionPane.showMessageDialog(null, "TV list data has been successfully cleared.",
                    "Clear Successful", JOptionPane.INFORMATION_MESSAGE);
        }
        tabbedPaneRefresh();
    }

    // MODIFIES: this
    // EFFECTS: refreshes the tabbed pane by removing and adding updated tab panels
    private void tabbedPaneRefresh() {
        setUpTVListPanels();
        tabbedPane.removeTabAt(4);
        tabbedPane.removeTabAt(3);
        tabbedPane.removeTabAt(2);
        tabbedPane.removeTabAt(1);
        tabbedPane.addTab("Plan to Watch", planToWatchPanel);
        tabbedPane.addTab("Currently Watching", currentlyWatchingPanel);
        tabbedPane.addTab("Completed", completedPanel);
        tabbedPane.addTab("Favourite Shows", favouriteShowsPanel);
    }

    // getters
    public ListOfTelevisionShowLists getListOfTVShowLists() {
        return this.listOfTVShowLists;
    }
}