package com.ricardo.tictactoe;

public class Cell {
    private ICellState state;

    public Cell(){
        this.state = new CellFree();
    }

    public boolean forTest_isFree() {
        return this.state.forTest_isFree();
    }

    public void putShape(IShape aShape){
        this.state = this.state.putShape(aShape);
    }

    public boolean compare(IShape aShape) {
        if(aShape == null) throw new InvalidShapeException();
        return this.state.compare(aShape);
    }
}