package ui.gui;

// JPanel for Currently Watching list to display the list's shows and selected show's details;
// contains option to add or remove shows to list, refresh the list, and edit details of selected show
public class CurrentlyWatchingPanel extends ShowListPanel {

    // EFFECTS: initializes JPanel for Currently Watching list of shows
    public CurrentlyWatchingPanel(TelevisionTrackerGUI televisionTrackerGui) {
        super(televisionTrackerGui, 2);
    }
}
