package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionList {
    private List<TelevisionShow> televisionList;
    private String listName;

    public TelevisionList(String listName) {
        this.televisionList = new ArrayList<>();
        this.listName = listName;
    }

    // MODIFIES: this
    // EFFECTS: adds television show to the TV list if it is not already in the list
    // and produces true; otherwise return false
    public boolean addShowToList(TelevisionShow show) {
        if (televisionList.contains(show)) {
            return false;
        } else {
            this.televisionList.add(show);
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: removes television show from the TV list if it is in the list and
    // produces true; otherwise return false
    public boolean removeShowFromList(TelevisionShow show) {
        if (televisionList.contains(show)) {
            this.televisionList.remove(show);
            return true;
        } else {
            return false;
        }
    }


}
