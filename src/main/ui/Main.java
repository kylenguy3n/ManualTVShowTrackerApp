package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            TelevisionTrackerApp televisionApp = new TelevisionTrackerApp();
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to run Television Tracker App: file not found");
        }
    }
}
