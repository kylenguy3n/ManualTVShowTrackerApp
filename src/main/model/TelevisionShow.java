package model;

import java.util.ArrayList;
import java.util.List;

// Represents a television show having the name of the show, a rating if provided, the date the show first aired, if
// provided, and the description of the show, if provided
public class TelevisionShow extends TelevisionComponent {
    private List<TelevisionSeason> showSeasons;
    private String description;

    // EFFECTS: constructs television show with the name of the show, an initial unset rating, an unset date of release,
    //          and an empty list to store the seasons of the show
    public TelevisionShow(String showName) {
        super(0, showName);
        showSeasons = new ArrayList<>();
        this.description = "";
    }

    // MODIFIES: this
    // EFFECTS: adds TV season to show
    public void addSeasonToShow(TelevisionSeason season) {
        showSeasons.add(season);
    }

    // MODIFIES: this
    // EFFECTS: sets a description for the television component
    public void setDescription(String description) {
        this.description = description;
    }

    // getters
    public List<TelevisionSeason> getShowSeasons() {
        return this.showSeasons;
    }

    public String getDescription() {
        return this.description;
    }
}
