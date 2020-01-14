package com.ricardo.tictactoe;

public interface IShape {
    boolean compare(IShape aShape);
    boolean compare(Cross cross);
    boolean compare(Circle circle);
}
