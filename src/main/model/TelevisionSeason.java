package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import persistence.WritableArray;

import java.util.ArrayList;
import java.util.List;

// Represents a television season having a season number in its show, a season name, a rating if provided, and
// the date the season's first episode released, if provided
public class TelevisionSeason extends TelevisionComponent implements Writable, WritableArray {
    private List<TelevisionEpisode> seasonEpisodes;

    // REQUIRES: seasonNumber >= 1
    // EFFECTS: constructs television season with which number the season is in its show, the season name, an initial
    //          unset rating, an unset date of release, and an empty list to store the episodes of the season
    public TelevisionSeason(int seasonNumber, String seasonName) {
        super(seasonNumber, seasonName);
        this.seasonEpisodes = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds TV episode to season
    public void addEpisodeToSeason(TelevisionEpisode episode) {
        seasonEpisodes.add(episode);
    }

    // getters
    public List<TelevisionEpisode> getSeasonEpisodes() {
        return this.seasonEpisodes;
    }

    @Override
    // EFFECTS: returns television season as a JSON object
    public JSONObject objectToJson() {
        JSONObject jsonTelevisionSeason = new JSONObject();
        jsonTelevisionSeason.put("Season Number", this.number);
        jsonTelevisionSeason.put("Season Name", this.title);
        jsonTelevisionSeason.put("Season Rating", this.rating);
        jsonTelevisionSeason.put("Season Date Released", this.dateReleased);
        jsonTelevisionSeason.put("Season Episodes", listOfObjectToJson());
        return jsonTelevisionSeason;
    }

    @Override
    // EFFECTS: returns season episodes in the television season as a JSON array
    public JSONArray listOfObjectToJson() {
        JSONArray jsonSeasonEpisodes = new JSONArray();

        for (TelevisionEpisode televisionEpisode : seasonEpisodes) {
            jsonSeasonEpisodes.put(televisionEpisode.objectToJson());
        }
        return jsonSeasonEpisodes;
    }
}
