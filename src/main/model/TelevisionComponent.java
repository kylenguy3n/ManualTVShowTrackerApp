package model;

public abstract class TelevisionComponent {
    protected int number;
    protected String name;
    protected int rating;
    protected String dateReleased;

    // REQUIRES: number >= 0
    // EFFECTS: constructs television component (a show, season, or episode class) with a number for which it appears
    //          in its television superclass (0 for the top class of show), the name of the component, an initial unset
    //          rating, and an unset date of release
    protected TelevisionComponent(int number, String name) {
        this.number = number;
        this.name = name;
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

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public String getDateReleased() {
        return this.dateReleased;
    }
}
