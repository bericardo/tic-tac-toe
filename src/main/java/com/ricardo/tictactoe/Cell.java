package com.ricardo.tictactoe;

public class Cell {

    private ICellState state;
    private IShape shape;

    public Cell(){
        this.state = new CellFree();
    }

    public boolean isFree() {
        return this.state.isFree();
    }

    public void putShape(IShape aShape){
        if(aShape == null) throw new InvalidShapeException();
        this.state = this.state.putShape(aShape);
    }

    public boolean compare(IShape aShape) {
        return this.state.compare(aShape);
    }
}