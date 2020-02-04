package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.Shape;

public interface ICellState {

    boolean compare(Shape aShape, Shape cellShape);

    Shape putShape(Shape aShape, Shape cellShape);
}
