package com.ricardo.tictactoe.shape;

public abstract class IShape {
    abstract boolean compare(IShape aShape);

    abstract boolean compare(Cross cross);

    abstract boolean compare(Circle circle);
}
