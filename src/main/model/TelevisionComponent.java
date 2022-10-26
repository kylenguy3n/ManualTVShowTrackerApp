package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an abstract television component (either a show, season, or episode) having a number to represent its
// sequence order if applicable, the title of the component, a rating if provided, and the date the component part
// released, if provided
public abstract class TelevisionComponent {
    protected int number;
    protected String title;
    protected int rating;
    protected String dateReleased;

    // REQUIRES: number >= 0
    // EFFECTS: constructs television component (a show, season, or episode class) with a number for which it appears
    //          in its superclass component (0 for show), the name of the component, an initial unset rating, and an
    //          unset date of release
    protected TelevisionComponent(int number, String title) {
        this.number = number;
        this.title = title;
        this.rating = 0;
        this.dateReleased = "";
    }

    // REQUIRES: 1 <= rating <= 10
    // MODIFIES: this
    // EFFECTS: sets a rating for the television component
    public void setRating(int rating) {
        this.rating = rating;
    }

    // REQUIRES: dateReleased must be in format of "yyyy-mm-dd"
    // MODIFIES: this
    // EFFECTS: sets date released for the television component
    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    // MODIFIES: this
    // EFFECTS: if rating has been set for the television component, resets rating back to having no rating and returns
    //          true; otherwise returns false
    public boolean removeRating() {
        if (rating != 0) {
            this.rating = 0;
            return true;
        } else {
            return false;
        }
    }

    // getters
    public int getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRating() {
        return this.rating;
    }

    public String getDateReleased() {
        return this.dateReleased;
    }
}
