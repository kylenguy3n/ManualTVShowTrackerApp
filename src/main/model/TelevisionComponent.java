package model;

import java.util.Date;

public abstract class TelevisionComponent {
    protected int number;
    protected String name;
    protected int rating;
    protected Date dateReleased;

    // REQUIRES: number >= 0
    // EFFECTS: constructs television component
    protected TelevisionComponent(int number, String name) {
        this.number = number;
        this.name = name;
        this.rating = 0;
        this.dateReleased = null;
    }

    //setters

    // REQUIRES: 1 <= rating <= 10
    // MODIFIES: this
    // EFFECTS: sets a rating for the television component
    public void setRating(int rating) {
        this.rating = rating;
    }

    // MODIFIES: this
    // EFFECTS: sets date released for the television component
    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    // MODIFIES: this
    // EFFECTS: resets rating back to having no rating
    public void removeRating() {
        this.rating = 0;
    }

    // getters
    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public Date getDateReleased() {
        return this.dateReleased;
    }
}
