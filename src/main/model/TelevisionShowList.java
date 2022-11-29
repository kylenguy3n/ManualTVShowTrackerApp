package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import persistence.WritableArray;

import java.util.ArrayList;
import java.util.List;

// Represents a list of television shows, having a name for the list and a list that includes television shows
public class TelevisionShowList implements Writable, WritableArray {
    private List<TelevisionShow> televisionShowList;
    private String listName;

    // EFFECTS: constructs an empty list to store TV shows and sets a name for the list
    public TelevisionShowList(String listName) {
        this.televisionShowList = new ArrayList<>();
        this.listName = listName;
    }

    // MODIFIES: this, Eventlog.getInstance()
    // EFFECTS: adds television show to the TV list if it is not already in the list
    //          and returns true and logs adding show to the event log; otherwise returns false
    public boolean addShowToList(TelevisionShow show) {
        if (televisionShowList.contains(show)) {
            return false;
        } else {
            this.televisionShowList.add(show);
            EventLog.getInstance().logEvent(new Event("Added " + show.getTitle() + " to " + listName));
            return true;
        }
    }

    // MODIFIES: this, Eventlog.getInstance()
    // EFFECTS: removes television show from the TV list if it is in the list and
    //          returns true logs removing show to the event log; otherwise returns false
    public boolean removeShowFromList(TelevisionShow show) {
        if (televisionShowList.contains(show)) {
            this.televisionShowList.remove(show);
            EventLog.getInstance().logEvent(new Event("Removed " + show.getTitle() + " from " + listName));
            return true;
        } else {
            return false;
        }
    }

    // getters
    public String getListName() {
        return this.listName;
    }

    public List<TelevisionShow> getTelevisionShowList() {
        return this.televisionShowList;
    }

    @Override
    // EFFECTS: returns television show list as a JSON object
    public JSONObject objectToJson() {
        JSONObject jsonTelevisionShowList = new JSONObject();
        jsonTelevisionShowList.put("List Name", this.listName);
        jsonTelevisionShowList.put("Television Shows", listOfObjectToJson());
        return jsonTelevisionShowList;
    }

    @Override
    // EFFECTS: returns television shows in the television show list as a JSON array
    public JSONArray listOfObjectToJson() {
        JSONArray jsonTelevisionShows = new JSONArray();

        for (TelevisionShow televisionShow : televisionShowList) {
            jsonTelevisionShows.put(televisionShow.objectToJson());
        }
        return jsonTelevisionShows;
    }
}
