package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import persistence.WritableArray;

import java.util.ArrayList;
import java.util.List;

// Represents a television show having the name of the show, a rating if provided, the date the show first aired, if
// provided, and the description of the show, if provided
public class TelevisionShow extends TelevisionComponent implements Writable, WritableArray {
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

    @Override
    // EFFECTS: returns television show as a JSON object
    public JSONObject objectToJson() {
        JSONObject jsonTelevisionShow = new JSONObject();
        jsonTelevisionShow.put("Show Number", this.number);
        jsonTelevisionShow.put("Show Name", this.title);
        jsonTelevisionShow.put("Show Rating", this.rating);
        jsonTelevisionShow.put("Show Date Released", this.dateReleased);
        jsonTelevisionShow.put("Show Description", this.description);
        jsonTelevisionShow.put("Show Seasons", listOfObjectToJson());
        return jsonTelevisionShow;
    }

    @Override
    // EFFECTS: returns television show seasons in the television show as a JSON array
    public JSONArray listOfObjectToJson() {
        JSONArray jsonShowSeasons = new JSONArray();

        for (TelevisionSeason televisionSeason : showSeasons) {
            jsonShowSeasons.put(televisionSeason.objectToJson());
        }
        return jsonShowSeasons;
    }
}
