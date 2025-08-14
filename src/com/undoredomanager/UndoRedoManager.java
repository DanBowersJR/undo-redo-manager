package com.undoredomanager;

public class UndoRedoManager<T> {
    private Node<T> current;

    // Add a new state
    public void addState(T state) {
        Node<T> newNode = new Node<>(state);
        if (current != null) {
            // Remove redo history
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
        }
        current = newNode;
    }

    // Undo: go to previous state
    public T undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return current.data;
        }
        System.out.println("No more undo steps available.");
        return null;
    }

    // Redo: go to next state
    public T redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.data;
        }
        System.out.println("No more redo steps available.");
        return null;
    }

    // Get current state without changing anything
    public T getCurrentState() {
        return current != null ? current.data : null;
    }
}
