package com.ricardo.tictactoe;

public class Cell {

    private boolean cellFree;
    private IShape shape;

    public Cell(){
        this.cellFree = true;
    }

    public boolean isFree() {
        return this.cellFree;
    }

    public void putShape(IShape aShape) {
        if(!cellFree) return;

        this.cellFree = false;
        this.shape = aShape;
    }

    public boolean compare(IShape aShape) {
        if(cellFree) return false;
        return this.shape.compare(aShape);
    }
}