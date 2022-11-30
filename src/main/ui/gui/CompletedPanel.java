package ui.gui;

// JPanel for Completed list to display the list's shows and selected show's details;
// contains option to add or remove shows to list, refresh the list, and edit details of selected show
public class CompletedPanel extends ShowListPanel {

    // EFFECTS: initializes JPanel for Completed list of shows
    public CompletedPanel(TelevisionTrackerGUI televisionTrackerGui) {
        super(televisionTrackerGui, 3);
    }
}
