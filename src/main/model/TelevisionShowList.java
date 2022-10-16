package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionShowList {
    private List<TelevisionShow> televisionShowList;
    private String listName;

    // EFFECTS: constructs an empty list to store TV shows and sets a name for the list
    public TelevisionShowList(String listName) {
        this.televisionShowList = new ArrayList<>();
        this.listName = listName;
    }

    // MODIFIES: this
    // EFFECTS: adds television show to the TV list if it is not already in the list
    //          and returns true; otherwise returns false
    public boolean addShowToList(TelevisionShow show) {
        if (televisionShowList.contains(show)) {
            return false;
        } else {
            this.televisionShowList.add(show);
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: removes television show from the TV list if it is in the list and
    //          returns true; otherwise returns false
    public boolean removeShowFromList(TelevisionShow show) {
        if (televisionShowList.contains(show)) {
            this.televisionShowList.remove(show);
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

}
