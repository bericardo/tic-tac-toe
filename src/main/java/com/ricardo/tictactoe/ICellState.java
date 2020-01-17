package com.ricardo.tictactoe;

public interface ICellState {
    boolean forTest_isFree();
    boolean compare(IShape aShape);

    ICellState putShape(IShape aShape);
}
