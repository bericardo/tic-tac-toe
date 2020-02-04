package com.ricardo.tictactoe.shape;

public class Circle extends Shape {
    public boolean compare(Shape aShape) {
        return aShape.compare(this);
    }

    public boolean compare(Cross cross) {
        return false;
    }

    public boolean compare(Circle circle) {
        return true;
    }
}
