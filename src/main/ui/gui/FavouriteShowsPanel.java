package ui.gui;

// JPanel for Favourite Shows list to display the list's shows and selected show's details;
// contains option to add or remove shows to list, refresh the list, and edit details of selected show
public class FavouriteShowsPanel extends ShowListPanel {

    // EFFECTS: initializes JPanel for Favourite Shows list
    public FavouriteShowsPanel(TelevisionTrackerGUI televisionTrackerGui) {
        super(televisionTrackerGui, 4);
    }
}
