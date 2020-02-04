package com.ricardo.tictactoe.shape;

public interface IComparable {
    boolean compare(Shape aShape);

    boolean compare(Cross cross);

    boolean compare(Circle circle);
}
