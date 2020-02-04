package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.Shape;

public class CellTaken implements ICellState {

    public boolean compare(Shape aShape, Shape cellShape) {
        return cellShape.compare(aShape);
    }

    public Shape putShape(Shape aShape, Shape cellShape) {
        return cellShape;
    }
}
