package ui;

import model.ListOfTelevisionShowLists;
import persistence.FileReader;
import persistence.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

// Class that handles file management including saving and loading data
public class FileManager {
    private static final String SAVED_FILE_DIR = "./data/savedTelevisionShowLists.json";
    private FileReader fileReader;
    private FileWriter fileWriter;
    private ListOfTelevisionShowLists listOfTelevisionShowLists;

    // EFFECTS: Initializes a new file manager with a file writer and reader and an empty list of TV show lists
    public FileManager() {
        fileWriter = new FileWriter(SAVED_FILE_DIR);
        fileReader = new FileReader(SAVED_FILE_DIR);
        listOfTelevisionShowLists = new ListOfTelevisionShowLists();
    }

    // MODIFIES: this
    // EFFECTS: overwrites listOfTelevisionShowLists with given list
    public void overwrite(ListOfTelevisionShowLists listOfTelevisionShowLists) {
        this.listOfTelevisionShowLists = listOfTelevisionShowLists;
    }

    // EFFECTS: returns listOfTelevisionShowLists
    public ListOfTelevisionShowLists getListOfTelevisionShowLists() {
        return this.listOfTelevisionShowLists;
    }

    // MODIFIES: this
    // EFFECTS: File writer saves the listOfTelevisionShowLists to the saved file location
    private void saveFile() throws FileNotFoundException {
        fileWriter.openFile();
        fileWriter.writeFile(this.listOfTelevisionShowLists);
        fileWriter.closeFile();
    }

    // MODIFIES: this
    // EFFECTS: File reader reads data off saved file and overwrites listOfTelevisionShowLists with the read list
    private void loadFile() throws IOException {
        this.listOfTelevisionShowLists = fileReader.readFile();
    }
}
