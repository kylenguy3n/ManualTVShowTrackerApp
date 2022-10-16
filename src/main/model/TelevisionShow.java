package model;

import java.util.ArrayList;
import java.util.List;

public class TelevisionShow extends TelevisionComponent {

    private List<TelevisionSeason> showSeasons;

    public TelevisionShow(String showName) {
        super(0, showName);
        showSeasons = new ArrayList<>();
    }

    //getters

    public List<TelevisionSeason> getshowSeasons() {
        return this.showSeasons;
    }

}
