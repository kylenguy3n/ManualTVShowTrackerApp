package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Class and methods are in reference to those used in the JsonReader class in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a reader that reads the television show lists from JSON data stored in a source file
public class FileReader {
    private String source;

    // EFFECTS: constructs a reader to read from a source file
    public FileReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads ListOfTelevisionShowLists from file and returns it; throws IOException if an error occurs when
    //          reading data from file
    public ListOfTelevisionShowLists readFile() throws IOException {
        String dataFromSource = readFileAsString(source);
        JSONObject jsonObject = new JSONObject(dataFromSource);
        return parseListOfTelevisionShowLists(jsonObject);
    }

    // EFFECTS: reads source file and returns it as string
    private String readFileAsString(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(str -> contentBuilder.append(str));
        }
        return contentBuilder.toString();
    }

    // MODIFIES: listOfTelevisionShowLists
    // EFFECTS: parses list of television show lists from
    private ListOfTelevisionShowLists parseListOfTelevisionShowLists(JSONObject jsonObject) {
//        String name = jsonObject.getString("Name");
        ListOfTelevisionShowLists listOfTelevisionShowLists = new ListOfTelevisionShowLists();
        addTelevisionShowLists(listOfTelevisionShowLists, jsonObject);
        return listOfTelevisionShowLists;
    }

    // MODIFIES: listOfTelevisionShowLists
    // EFFECTS: parses televisionShowLists from JSON object and adds them to listOfTelevisionShowLists
    private void addTelevisionShowLists(ListOfTelevisionShowLists listOfTelevisionShowLists, JSONObject jsonObject) {
        JSONArray jsonTelevisionShowLists = jsonObject.getJSONArray("Contained Lists");
        for (Object json : jsonTelevisionShowLists) {
            JSONObject nextTelevisionShowList = (JSONObject) json;
            addTelevisionShowList(listOfTelevisionShowLists, nextTelevisionShowList);
        }
    }

    // MODIFIES: listOfTelevisionShowLists
    // EFFECTS: parses televisionShowList from JSON object and adds it to listOfTelevisionShowLists
    private void addTelevisionShowList(ListOfTelevisionShowLists listOfTelevisionShowLists, JSONObject jsonObject) {
        String name = jsonObject.getString("List Name");
        TelevisionShowList televisionShowList = new TelevisionShowList(name);
        JSONArray jsonTelevisionShows = jsonObject.getJSONArray("Television Shows");
        for (Object json: jsonTelevisionShows) {
            JSONObject nexTelevisionShow = (JSONObject) json;
            addTelevisionShow(televisionShowList, nexTelevisionShow);
        }
        listOfTelevisionShowLists.addTelevisionShowListToList(televisionShowList);
    }

    // MODIFIES: televisionShowList
    // EFFECTS: parses televisionShow from JSON object and adds it to televisionShowList
    private void addTelevisionShow(TelevisionShowList televisionShowList, JSONObject jsonObject) {
        int number = jsonObject.getInt("Show Number");
        String name = jsonObject.getString("Show Name");
        int rating = jsonObject.getInt("Show Rating");
        String dateReleased = jsonObject.getString("Show Date Released");
        String description = jsonObject.getString("Show Description");
        TelevisionShow televisionShow = new TelevisionShow(name);
        televisionShow.setRating(rating);
        televisionShow.setDateReleased(dateReleased);
        televisionShow.setDescription(description);
        JSONArray jsonTelevisionSeasons = jsonObject.getJSONArray("Show Seasons");
        for (Object json : jsonTelevisionSeasons) {
            JSONObject nextTelevisionSeason = (JSONObject) json;
            addTelevisionSeason(televisionShow, nextTelevisionSeason);
        }
        televisionShowList.addShowToList(televisionShow);
    }

    // MODIFIES: televisionShow
    // EFFECTS: parses televisionSeason from JSON object and adds it to televisionShow
    private void addTelevisionSeason(TelevisionShow televisionShow, JSONObject jsonObject) {
        int number = jsonObject.getInt("Season Number");
        String name = jsonObject.getString("Season Name");
        int rating = jsonObject.getInt("Season Rating");
        String dateReleased = jsonObject.getString("Season Date Released");
        TelevisionSeason televisionSeason = new TelevisionSeason(number, name);
        televisionSeason.setRating(rating);
        televisionSeason.setDateReleased(dateReleased);
        JSONArray jsonTelevisionEpisodes = jsonObject.getJSONArray("Season Episodes");
        for (Object json : jsonTelevisionEpisodes) {
            JSONObject nextTelevisionEpisode = (JSONObject) json;
            addTelevisionEpisode(televisionSeason, nextTelevisionEpisode);
        }
        televisionShow.addSeasonToShow(televisionSeason);
    }

    // MODIFIES: televisionSeason
    // EFFECTS: parses televisionEpisode from JSON object and adds it to televisionSeason
    private void addTelevisionEpisode(TelevisionSeason televisionSeason, JSONObject jsonObject) {
        int number = jsonObject.getInt("Episode Number");
        String name = jsonObject.getString("Episode Name");
        int rating = jsonObject.getInt("Episode Rating");
        String dateReleased = jsonObject.getString("Episode Date Released");
        TelevisionEpisode televisionEpisode = new TelevisionEpisode(number, name);
        televisionEpisode.setRating(rating);
        televisionEpisode.setDateReleased(dateReleased);
        televisionSeason.addEpisodeToSeason(televisionEpisode);
    }
}
