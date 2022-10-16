package model;

public abstract class TelevisionComponent {
    protected int number;
    protected String name;
    protected int rating;
    protected String description;


    //EFFECTS: constructs TV episode with episode number in its season
    protected TelevisionComponent(int number, String name) {
        this.number = number;
        this.name = name;
        this.rating = 0;
        this.description = "";
    }

    //REQUIRES: 1 <= rating <= 10
    //MODIFIES: this
    //EFFECTS: sets a rating for the television component
    public void setRating(int rating) {
        this.rating = rating;
    }

    //MODIFIES: this
    //EFFECTS: sets a description for the television component
    public void setDescription(String description) {
        this.description = description;
    }

    //getters
    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public String getDescription() {
        return this.description;
    }
}
