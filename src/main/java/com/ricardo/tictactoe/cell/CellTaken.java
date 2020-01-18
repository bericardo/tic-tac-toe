package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public class CellTaken implements ICellState {

    public boolean forTest_isFree() {
        return false;
    }

    public boolean compare(IShape aShape, IShape cellShape) {
        return cellShape.compare(aShape);
    }

    public IShape putShape(IShape aShape, IShape cellShape) {
        return cellShape;
    }
}
