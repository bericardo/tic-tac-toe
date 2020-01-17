package com.ricardo.tictactoe.shape;

public class Circle implements IShape {
    public boolean compare(IShape aShape) {
        return aShape.compare(this);
    }

    public boolean compare(Cross cross) {
        return false;
    }

    public boolean compare(Circle circle) {
        return true;
    }
}
