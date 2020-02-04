package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.Shape;

public class Cell {
    private Shape shape;
    private ICellState state;

    public Cell() {
        this.state = new CellFree();
    }

    public void putShape(Shape aShape) {
        this.shape = this.state.putShape(aShape, this.shape);
        this.state = new CellTaken();
    }

    public boolean compare(Shape aShape) {
        if (aShape == null) throw new InvalidShapeException();
        return this.state.compare(aShape, this.shape);
    }
}