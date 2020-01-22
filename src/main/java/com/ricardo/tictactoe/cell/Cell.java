package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public class Cell {
    private IShape shape;
    private ICellState state;

    public Cell() {
        this.state = new CellFree();
    }

    public boolean forTest_isFree() {
        return this.state.forTest_isFree();
    }

    public boolean putShape(IShape aShape) {
        this.shape = this.state.putShape(aShape, this.shape);
        this.state = new CellTaken();

        return this.shape.compare(aShape);
    }

    public boolean compare(IShape aShape) {
        if (aShape == null) throw new InvalidShapeException();
        return this.state.compare(aShape, this.shape);
    }
}