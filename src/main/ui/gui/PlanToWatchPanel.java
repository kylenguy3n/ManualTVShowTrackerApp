package ui.gui;

// JPanel for Plan To Watch list to display the list's shows and selected show's details;
// contains option to add or remove shows to list, refresh the list, and edit details of selected show
public class PlanToWatchPanel extends ShowListPanel {

    // EFFECTS: initializes JPanel for Plan To Watch list of shows
    public PlanToWatchPanel(TelevisionTrackerGUI televisionTrackerGui) {
        super(televisionTrackerGui, 1);
    }
}
