package com.ricardo.tictactoe.shape;

public interface IShape {
    boolean compare(IShape aShape);

    boolean compare(Cross cross);

    boolean compare(Circle circle);
}
