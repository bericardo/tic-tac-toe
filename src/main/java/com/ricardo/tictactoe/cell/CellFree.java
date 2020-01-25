package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public class CellFree implements ICellState {

    public boolean compare(IShape aShape, IShape cellShape) {
        return false;
    }

    public IShape putShape(IShape aShape, IShape cellShape) {
        if (aShape == null) throw new InvalidShapeException();
        return aShape;
    }
}
