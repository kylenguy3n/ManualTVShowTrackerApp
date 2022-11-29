package ui;

import ui.gui.GUI;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        new GUI();

        try {
            new TelevisionTrackerApp();
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to run Television Tracker App: file not found");
        }
    }
}
