package com.ricardo.tictactoe;

public class CellFree implements ICellState {
    public boolean forTest_isFree() {
        return true;
    }

    public boolean compare(IShape aShape) {
        return false;
    }

    public ICellState putShape(IShape aShape) {
        return new CellTaken(aShape);
    }
}
