package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public class CellTaken implements ICellState {
    private IShape shape;

    public CellTaken(IShape aShape) {
        this.shape = aShape;
    }

    public boolean forTest_isFree() {
        return false;
    }

    public boolean compare(IShape aShape) {
        return this.shape.compare(aShape);
    }

    public ICellState putShape(IShape aShape) {
        return this;
    }
}
