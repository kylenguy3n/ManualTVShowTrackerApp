package model;

// Represents a television episode having an episode number in its season, episode name
public class TelevisionEpisode extends TelevisionComponent {

    // REQUIRES: episodeNumber >= 1
    // EFFECTS: constructs TV episode with season episode number, episode name
    public TelevisionEpisode(int episodeNumber, String episodeName) {
        super(episodeNumber, episodeName);
    }
}
