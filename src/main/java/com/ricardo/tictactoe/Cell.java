package com.ricardo.tictactoe;

public class Cell {

    private boolean cellFree;

    public Cell(){
        this.cellFree = true;
    }

    public boolean isFree() {
        return this.cellFree;
    }

    public void putShape(IShape aShape) {
        this.cellFree = false;
    }

    public boolean compare(IShape circle) {
        return false;
    }
}