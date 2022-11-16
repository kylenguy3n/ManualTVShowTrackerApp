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
    public MainMenuPanel(GUI gui) {
        setBorder(BorderFactory.createTitledBorder("Main Menu"));
        setLayout(new GridBagLayout());

        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Last Saved Data");
        clearButton = new JButton("Clear Current Data");
        ImageIcon image = new ImageIcon("data/images/MainMenu.png");
        imageLabel = new JLabel(image);
        guidanceLabel = new JLabel("Please select one of the following TV show lists on the left to view it.");
        gridConstraints = new GridBagConstraints();

        addImageLabel();
        addGuidanceLabel();
        addSaveButton(gui);
        addLoadButton(gui);
        addClearButton(gui);
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
    private void addSaveButton(GUI gui) {
        gridConstraints.insets = new Insets(20, 5, 0, 5);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        add(saveButton, gridConstraints);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.saveData();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds the load button as a component to the main menu panel and adds a load data action when pressed
    private void addLoadButton(GUI gui) {
        gridConstraints.insets = new Insets(20, 5, 0, 5);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 1;
        add(loadButton, gridConstraints);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.loadData();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds the clear button as a component to the main menu panel and adds a clear data action when pressed
    //          with appropriate warnings to confirm clearing the data
    private void addClearButton(GUI gui) {
        gridConstraints.insets = new Insets(20, 5, 0, 5);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 2;
        add(clearButton, gridConstraints);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you would like to clear the data?", "Warning!",
                        JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    gui.setUpListOfTVShowLists();
                    JOptionPane.showMessageDialog(null, "TV list data has been successfully cleared.",
                            "Clear Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
