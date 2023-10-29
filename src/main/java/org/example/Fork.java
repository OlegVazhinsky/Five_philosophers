package org.example;

public class Fork {
    private boolean laysOnTable;

    public Fork(){
        laysOnTable = true;
    }

    public void takeFork() {
        laysOnTable = false;
    }

    public void putForkDown() {
        laysOnTable = true;
    }

    public boolean isOnTable() {
        return laysOnTable;
    }
}
