package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public interface ICellState {

    boolean compare(IShape aShape, IShape cellShape);

    IShape putShape(IShape aShape, IShape cellShape);
}
