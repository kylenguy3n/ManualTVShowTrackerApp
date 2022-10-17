package model;

// Represents a television episode having an episode number in its season, an episode name, a rating if provided, and
// the date the episode released, if provided
public class TelevisionEpisode extends TelevisionComponent {

    // REQUIRES: episodeNumber >= 1
    // EFFECTS: constructs television episode with the episode number it appears in its season, the episode name, an
    // initial unset rating, and an unset date of release
    public TelevisionEpisode(int episodeNumber, String episodeName) {
        super(episodeNumber, episodeName);
    }
}
