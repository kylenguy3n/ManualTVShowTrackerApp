package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionSeason extends TelevisionComponent {
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
}
