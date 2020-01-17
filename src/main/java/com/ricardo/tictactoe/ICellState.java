package com.ricardo.tictactoe;

public interface ICellState {
    boolean isFree();
    boolean compare(IShape aShape);

    ICellState putShape(IShape aShape);
}
