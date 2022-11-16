package ui.gui;

import model.ListOfTelevisionShowLists;
import ui.FileManager;

import javax.swing.*;
import java.awt.*;

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

    // EFFECTS: Initializes the program GUI
    public GUI() {
        fileManager = new FileManager();
        listOfTVShowLists = new ListOfTelevisionShowLists();

        setUpFrame();

        mainMenuPanel = new MainMenuPanel();
        planToWatchPanel = new PlanToWatchPanel();
        currentlyWatchingPanel = new CurrentlyWatchingPanel();
        completedPanel = new CompletedPanel();
        favouriteShowsPanel = new FavouriteShowsPanel();

        setUpPane();
    }

    //MODIFIES: this
    // EFFECTS: Sets up JFrame for the TV Tracker GUI
    public void setUpFrame() {
        frame = new JFrame("Television Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        Image icon = Toolkit.getDefaultToolkit().getImage("images/Icon.png");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
    }

    //MODIFIES: this
    // EFFECTS: Sets up JTabbedPane side pane for the TV Tracker GUI a main menu option and option for all TV lists
    public void setUpPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(SwingConstants.LEFT);

        tabbedPane.addTab("Main Menu", mainMenuPanel);
        tabbedPane.addTab("Plan To Watch", planToWatchPanel);
        tabbedPane.addTab("Currently Watching", currentlyWatchingPanel);
        tabbedPane.addTab("Completed", completedPanel);
        tabbedPane.addTab("Favourite Shows", favouriteShowsPanel);

        Container contentPane = frame.getContentPane();
        contentPane.add(tabbedPane);
    }
}