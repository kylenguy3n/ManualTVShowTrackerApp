package ui.gui;

import model.TelevisionSeason;
import model.TelevisionShow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// InfoPanel
public class InfoPanel extends JPanel implements ActionListener {
    private JLabel titleLabel;
    private JLabel seasonLabel;
    private JLabel episodeLabel;
    private JLabel dateReleasedLabel;
    private JLabel descriptionLabel;
    private JLabel ratingLabel;
    private JTextField titleField;
    private JTextField seasonField;
    private JTextField episodeField;
    private JTextField dateReleasedField;
    private JTextArea descriptionField;
    private JTextField ratingField;
    private GridBagConstraints gridConstraints;
    private JButton editButton;


    // EFFECTS: initializes the information panel of a TV show
    public InfoPanel() {
        setBorder(BorderFactory.createTitledBorder("Show Details"));
        setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();

        titleLabel = new JLabel("Title: ");
        seasonLabel = new JLabel("No. of Seasons: ");
        episodeLabel = new JLabel("No. of Episodes: ");
        dateReleasedLabel = new JLabel("Date Released: ");
        descriptionLabel = new JLabel("Description: ");
        ratingLabel = new JLabel("Rating: ");
        editButton = new JButton("Edit Details");
    }

    // MODIFIES: this
    // EFFECTS:
    public void displayShowInfo(TelevisionShow show) {
        this.removeAll();
        this.revalidate();
        this.repaint();

        addLabels();
        setUpFields(show);
        addFields();
        addEditButton();
        editButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: adds labels for the fields of the TV show
    private void addLabels() {
        gridConstraints.anchor = GridBagConstraints.LINE_END;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        add(titleLabel, gridConstraints);
        gridConstraints.gridy = 1;
        add(seasonLabel, gridConstraints);
        gridConstraints.gridy = 2;
        add(episodeLabel, gridConstraints);
        gridConstraints.gridy = 3;
        add(dateReleasedLabel, gridConstraints);
        gridConstraints.gridy = 4;
        add(descriptionLabel, gridConstraints);
        gridConstraints.gridy = 5;
        add(ratingLabel, gridConstraints);
    }

    // EFFECTS:
    private void setUpFields(TelevisionShow show) {
        titleField = new JTextField(show.getTitle(),  15);
        seasonField = new JTextField(Integer.toString(show.getShowSeasons().size()), 10);
        episodeField = new JTextField(Integer.toString(countEpisodes(show)), 10);
        dateReleasedField = new JTextField(show.getDateReleased(), 10);
        descriptionField = new JTextArea(show.getDescription(), 10, 15);
        ratingField = new JTextField(Integer.toString(show.getRating()), 10);

        descriptionField.setOpaque(false);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);

        titleField.setEditable(false);
        titleField.setBorder(null);
        seasonField.setEditable(false);
        seasonField.setBorder(null);
        episodeField.setEditable(false);
        episodeField.setBorder(null);
        dateReleasedField.setEditable(false);
        dateReleasedField.setBorder(null);
        descriptionField.setEditable(false);
        ratingField.setEditable(false);
        ratingField.setBorder(null);
    }

    // EFFECTS:
    private int countEpisodes(TelevisionShow show) {
        int episodeAmount = 0;
        for (TelevisionSeason season : show.getShowSeasons()) {
            episodeAmount += season.getSeasonEpisodes().size();
        }
        return episodeAmount;
    }

    // EFFECTS:
    private void addFields() {
        gridConstraints.anchor = GridBagConstraints.LINE_START;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        add(titleField, gridConstraints);
        gridConstraints.gridy = 1;
        add(seasonField, gridConstraints);
        gridConstraints.gridy = 2;
        add(episodeField, gridConstraints);
        gridConstraints.gridy = 3;
        add(dateReleasedField, gridConstraints);
        gridConstraints.gridy = 4;
        add(descriptionField, gridConstraints);
        gridConstraints.gridy = 5;
        add(ratingField, gridConstraints);
    }

    private void addEditButton() {
        editButton.setMinimumSize(new Dimension(150, 20));
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.weighty = 0.1;
        add(editButton, gridConstraints);
    }

    // MODIFIES: this
    // EFFECTS:
    @Override
    public void actionPerformed(ActionEvent e) {
        // STUB
    }
}
