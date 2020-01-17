package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public class CellFree implements ICellState {
    public boolean forTest_isFree() {
        return true;
    }

    public boolean compare(IShape aShape) {
        return false;
    }

    public ICellState putShape(IShape aShape) {
        if (aShape == null) throw new InvalidShapeException();
        return new CellTaken(aShape);
    }
}
