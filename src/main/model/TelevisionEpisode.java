package model;

// Represents a television episode having an episode number in its season, episode name,
public class TelevisionEpisode extends TelevisionComponent {

    // REQUIRES: episodeNumber >= 1
    // EFFECTS: constructs television episode with the episode number it appears in its season, the episode name, an
    // initial unset rating, and an unset date of release
    public TelevisionEpisode(int episodeNumber, String episodeName) {
        super(episodeNumber, episodeName);
    }
}
