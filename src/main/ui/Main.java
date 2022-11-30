package ui;

import ui.gui.TelevisionTrackerGUI;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        new TelevisionTrackerGUI();

//        try {
//            new TelevisionTrackerConsole();
//        } catch (FileNotFoundException e) {
//            System.out.println("\nUnable to run Television Tracker App: file not found");
//        }
    }
}
