package persistence;

import model.ListOfTelevisionShowLists;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Class and methods are in reference to those used in the JsonWriter class in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a writer that writes list of television show lists as JSON data to store in a destination file
public class FileWriter {
    private static final int INDENT_FACTOR = 4;
    private String destination;
    private PrintWriter writer;

    // EFFECTS: constructs a writer to write to given destination file
    public FileWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if error occurs while opening or creating the destination
    //          file
    public void openFile() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of list of television show lists to destination file
    public void writeFile(ListOfTelevisionShowLists listOfTelevisionShowLists) {
        JSONObject jsonObject = listOfTelevisionShowLists.objectToJson();
        saveToFile(jsonObject.toString(INDENT_FACTOR));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void closeFile() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to destination file
    private void saveToFile(String jsonObjectToString) {
        writer.print(jsonObjectToString);
    }
}
