package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates a Main Menu panel
public class MainMenuPanel extends JPanel {
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;
    private JLabel imageLabel;
    private JLabel guidanceLabel;
    private GridBagConstraints gridConstraints;

    // EFFECTS: Initializes the main menu panel with a title, logo, and 3 buttons for data functionality
    public MainMenuPanel(TelevisionTrackerGUI televisionTrackerGui) {
        setBorder(BorderFactory.createTitledBorder("Main Menu"));
        setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();

        saveButton = new JButton("Save Current Data");
        loadButton = new JButton("Load Last Saved Data");
        clearButton = new JButton("Clear Current Data");
        ImageIcon image = new ImageIcon("data/images/MainMenu.png");
        imageLabel = new JLabel(image);
        guidanceLabel = new JLabel("Please select one of the following TV show lists on the left to view it.");

        addImageLabel();
        addGuidanceLabel();
        addSaveButton(televisionTrackerGui);
        addLoadButton(televisionTrackerGui);
        addClearButton(televisionTrackerGui);
    }

    // MODIFIES: this
    // EFFECTS: Adds the title and logo in the image label as a component to the main menu panel
    private void addImageLabel() {
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 1;
        add(imageLabel, gridConstraints);
    }

    // MODIFIES: this
    // EFFECTS: Adds the guidance Label as a component to the main menu panel and implements
    private void addGuidanceLabel() {
        gridConstraints.insets = new Insets(20, 0, 0, 0);
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 1;
        add(guidanceLabel, gridConstraints);
    }

    // MODIFIES: this
    // EFFECTS: Adds the save button as a component to the main menu panel and adds a sava data action when pressed
    private void addSaveButton(TelevisionTrackerGUI televisionTrackerGui) {
        gridConstraints.insets = new Insets(10, 5, 0, 5);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 1;
        add(saveButton, gridConstraints);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                televisionTrackerGui.saveData();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds the load button as a component to the main menu panel and adds a load data action when pressed
    private void addLoadButton(TelevisionTrackerGUI televisionTrackerGui) {
        gridConstraints.insets = new Insets(10, 5, 0, 5);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 1;
        add(loadButton, gridConstraints);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                televisionTrackerGui.loadData();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds the clear button as a component to the main menu panel and adds a clear data action when pressed
    //          with appropriate warnings to confirm clearing the data
    private void addClearButton(TelevisionTrackerGUI televisionTrackerGui) {
        gridConstraints.insets = new Insets(10, 5, 0, 5);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 1;
        add(clearButton, gridConstraints);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                televisionTrackerGui.clearData();
            }
        });
    }
}
