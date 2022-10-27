package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a television episode having an episode number in its season, an episode name, a rating if provided, and
// the date the episode released, if provided
public class TelevisionEpisode extends TelevisionComponent implements Writable {

    // REQUIRES: episodeNumber >= 1
    // EFFECTS: constructs television episode with the episode number it appears in its season, the episode name, an
    // initial unset rating, and an unset date of release
    public TelevisionEpisode(int episodeNumber, String episodeName) {
        super(episodeNumber, episodeName);
    }

    @Override
    // EFFECTS: returns television episode as a JSON object
    public JSONObject objectToJson() {
        JSONObject jsonTelevisionEpisode = new JSONObject();
        jsonTelevisionEpisode.put("Episode Number", this.number);
        jsonTelevisionEpisode.put("Episode Name", this.title);
        jsonTelevisionEpisode.put("Episode Rating", this.rating);
        jsonTelevisionEpisode.put("Episode Date Released", this.dateReleased);
        return jsonTelevisionEpisode;
    }
}
