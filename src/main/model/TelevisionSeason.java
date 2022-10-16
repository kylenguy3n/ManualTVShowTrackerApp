package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionSeason extends TelevisionComponent {
    private List<TelevisionEpisode> seasonEpisodes;

    // REQUIRES: seasonNumber >= 1
    // EFFECTS: constructs TV season with season number in show, season name
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

}
