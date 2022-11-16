package ui.gui;

import javax.swing.*;

// Creates a Main Menu panel
public class MainMenuPanel extends JPanel {
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;

    // EFFECTS: Initializes the main menu panel
    public MainMenuPanel() {

        JLabel imageLabel = new JLabel("images/Main Menu.png");
        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Last Saved Data");
        clearButton = new JButton("Clear Current Data");

    }
}
