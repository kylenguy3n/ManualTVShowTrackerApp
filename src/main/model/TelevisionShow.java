package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionShow extends TelevisionComponent {
    private List<TelevisionSeason> showSeasons;
    private String description;

    // EFFECTS: constructs television show
    public TelevisionShow(String showName) {
        super(0, showName);
        showSeasons = new ArrayList<>();
        this.description = "";
    }

    // MODIFIES: this
    // EFFECTS: sets a description for the television component
    public void setDescription(String description) {
        this.description = description;
    }

    // MODIFIES: this
    // EFFECTS: adds TV season to show
    public void addSeasonToShow(TelevisionSeason season) {
        showSeasons.add(season);
    }

    // getters
    public String getDescription() {
        return this.description;
    }

    public List<TelevisionSeason> getShowSeasons() {
        return this.showSeasons;
    }
}
