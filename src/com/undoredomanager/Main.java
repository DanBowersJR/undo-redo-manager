package com.undoredomanager;

public class Main {
    public static void main(String[] args) {
        // Example with Strings
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("1");
        manager.addState("2");
        manager.addState("3");
        manager.addState("4");
        manager.addState("5");

        System.out.println("Current state: " + manager.getCurrentState()); // 5

        manager.undo();
        System.out.println("After undo: " + manager.getCurrentState()); // 4

        manager.undo();
        System.out.println("After second undo: " + manager.getCurrentState()); // 3

        manager.redo();
        System.out.println("After redo: " + manager.getCurrentState()); // 4

        manager.addState("6");
        System.out.println("After adding new state: " + manager.getCurrentState()); // 6
    }
}
