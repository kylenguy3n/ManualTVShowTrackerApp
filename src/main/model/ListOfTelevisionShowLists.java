package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import persistence.WritableArray;

import java.util.ArrayList;
import java.util.List;

// Represents a list of television show lists, having a name for the list of lists, and a list that includes lists
// which hold television shows
public class ListOfTelevisionShowLists implements Writable, WritableArray {
    private String listOfListsName;
    private List<TelevisionShowList> listOfTelevisionShowLists;

    // EFFECTS: constructs an empty list to store TV show lists and sets name for the list
    public ListOfTelevisionShowLists() {
        this.listOfTelevisionShowLists = new ArrayList<>();
        this.listOfListsName = "List of Television Show Lists";
    }

    // MODIFIES: this
    // EFFECTS: adds television show list to the list of television show lists
    //          and returns true; otherwise returns false
    public boolean addTelevisionShowListToList(TelevisionShowList showList) {
        this.listOfTelevisionShowLists.add(showList);
        return true;
    }

    // getters
    public String getListOfListsName() {
        return this.listOfListsName;
    }

    public List<TelevisionShowList> getListOfTelevisionShowLists() {
        return this.listOfTelevisionShowLists;
    }

    @Override
    public JSONObject objectToJson() {
        JSONObject jsonListOfTelevisionShowLists = new JSONObject();
        jsonListOfTelevisionShowLists.put("Name", this.listOfListsName);
        jsonListOfTelevisionShowLists.put("Contained Lists", listOfObjectToJson());
        return jsonListOfTelevisionShowLists;
    }

    @Override
    public JSONArray listOfObjectToJson() {
        JSONArray jsonTelevisionShowLists = new JSONArray();

        for (TelevisionShowList televisionShowList : listOfTelevisionShowLists) {
            jsonTelevisionShowLists.put(televisionShowList.objectToJson());
        }
        return jsonTelevisionShowLists;
    }
}
