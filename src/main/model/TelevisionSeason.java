package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionSeason extends TelevisionComponent {

    private List<TelevisionEpisode> seasonEpisodes;

    public TelevisionSeason(int seasonNumber, String seasonName) {
        super(seasonNumber, seasonName);
        this.seasonEpisodes = new ArrayList<>();
    }

    //getters

    public List<TelevisionEpisode> getSeasonEpisodes() {
        return this.seasonEpisodes;
    }

}
