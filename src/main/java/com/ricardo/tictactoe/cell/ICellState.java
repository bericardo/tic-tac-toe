package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.IShape;

public interface ICellState {
    boolean forTest_isFree();

    boolean compare(IShape aShape);

    ICellState putShape(IShape aShape);
}
