package com.ricardo.tictactoe.shape;

public class Cross extends Shape {
    public boolean compare(Shape aShape) {
        return aShape.compare(this);
    }

    public boolean compare(Cross cross) {
        return true;
    }

    public boolean compare(Circle circle) {
        return false;
    }
}
