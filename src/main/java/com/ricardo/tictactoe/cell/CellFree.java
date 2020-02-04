package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.Shape;

public class CellFree implements ICellState {

    public boolean compare(Shape aShape, Shape cellShape) {
        return false;
    }

    public Shape putShape(Shape aShape, Shape cellShape) {
        if (aShape == null) throw new InvalidShapeException();
        aShape.setPlaced();
        return aShape;
    }
}
