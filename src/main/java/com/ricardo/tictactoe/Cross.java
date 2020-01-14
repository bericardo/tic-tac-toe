package com.ricardo.tictactoe;

public class Cross implements IShape {
    public boolean compare(IShape aShape) {
        return aShape.compare(this);
    }

    public boolean compare(Cross cross) {
        return true;
    }

    public boolean compare(Circle circle) {
        return false;
    }
}
