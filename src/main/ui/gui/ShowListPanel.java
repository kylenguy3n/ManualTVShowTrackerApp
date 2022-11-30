package ui.gui;

import model.ListOfTelevisionShowLists;
import model.TelevisionShow;
import model.TelevisionShowList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstract class of JPanel for each show list to display the list's shows and selected show's details;
// contains option to add or remove shows to list, refresh the list, and edit details of selected show
public abstract class ShowListPanel extends JPanel {
    protected ListPanel listPanel;
    protected InfoPanel infoPanel;
    protected JButton addShowButton;
    protected JButton removeShowButton;
    protected JButton refreshListButton;
    protected GridBagConstraints gridConstraints;
    protected TelevisionShowList showList;

    // EFFECTS: Initializes the show list panel with a title of the list, a JList with all the shows in that list,
    //          a JPanel with the details of selected shows in the list, and buttons to add or remove shows, and
    //          to edit a selected show and refresh the list
    public ShowListPanel(TelevisionTrackerGUI televisionTrackerGui, int whichList) {

        setShowListBorder(whichList);
        setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();

        ListOfTelevisionShowLists showListsList =  televisionTrackerGui.getListOfTVShowLists();
        showList = selectWhichList(showListsList, whichList);

        infoPanel = new InfoPanel();
        listPanel = new ListPanel(showList, infoPanel);

        addShowButton = new JButton("Add a Show");
        removeShowButton = new JButton("Remove a Show");
        refreshListButton = new JButton("Refresh List");

        Dimension buttonSize = new Dimension(150, 20);
        addShowButton.setPreferredSize(buttonSize);
        removeShowButton.setPreferredSize(buttonSize);
        refreshListButton.setPreferredSize(buttonSize);

        setUpSplitPane();
        addAddShowButton();
        addRemoveShowButton();
        addRefreshListButton();
    }

    // MODIFIES: this
    // EFFECTS: Selects what title to put on the panel border, depending on what TV show list
    protected void setShowListBorder(int whichList) {
        switch (whichList) {
            case 1:
                setBorder(BorderFactory.createTitledBorder("Plan to Watch List"));
                break;
            case 2:
                setBorder(BorderFactory.createTitledBorder("Currently Watching List"));
                break;
            case 3:
                setBorder(BorderFactory.createTitledBorder("Completed List"));
                break;
            default:
                setBorder(BorderFactory.createTitledBorder("Favourite Shows List"));
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: Selects what show list to obtain, depending on which list number is given
    protected TelevisionShowList selectWhichList(ListOfTelevisionShowLists showListsList, int whichList) {
        TelevisionShowList showList = null;
        switch (whichList) {
            case 1:
                showList = showListsList.getListOfTelevisionShowLists().get(0);
                break;
            case 2:
                showList = showListsList.getListOfTelevisionShowLists().get(1);
                break;
            case 3:
                showList = showListsList.getListOfTelevisionShowLists().get(2);
                break;
            default:
                showList = showListsList.getListOfTelevisionShowLists().get(3);
                break;
        }
        return showList;
    }

    // MODIFIES: this
    // EFFECTS: Adds the split panel for show list and information to the TV show list panel
    protected void setUpSplitPane() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, infoPanel);
        splitPane.setPreferredSize(new Dimension(700, 600));
        splitPane.setDividerLocation(350);

        gridConstraints.gridy = 0;
        gridConstraints.gridx = 0;
        add(splitPane, gridConstraints);
    }


    // MODIFIES: this
    // EFFECTS: adds the add show button to the panel, allowing user to add a new show's title to the list
    private void addAddShowButton() {
        gridConstraints.insets = new Insets(30, 5, 0, 5);
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 0;
        add(addShowButton, gridConstraints);

        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = JOptionPane.showInputDialog(null,
                        "What it the title of the show?", "Add TV Show", JOptionPane.QUESTION_MESSAGE);
                showList.addShowToList(new TelevisionShow(response));
                listPanel.refreshList(showList);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: adds the remove show button to the panel, allowing user to remove a selected show from the list
    private void addRemoveShowButton() {
        gridConstraints.insets = new Insets(5, 5, 0, 5);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        add(removeShowButton, gridConstraints);

        removeShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you would like to remove the show?", "Warning!",
                        JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    int showIndex = listPanel.getJList().getSelectedIndex();
                    TelevisionShow show = showList.getTelevisionShowList().get(showIndex);
                    showList.removeShowFromList(show);
                    listPanel.refreshList(showList);
                    JOptionPane.showMessageDialog(null, "The show has been successfully removed.",
                            "Remove Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: adds the refresh button to the panel, allowing user to refresh and get most updated details of list
    private void addRefreshListButton() {
        gridConstraints.insets = new Insets(5, 5, 0, 5);
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 0;
        add(refreshListButton, gridConstraints);

        refreshListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPanel.refreshList(showList);
            }
        });
    }
}
