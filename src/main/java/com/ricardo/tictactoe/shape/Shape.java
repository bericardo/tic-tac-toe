package com.ricardo.tictactoe.shape;

public abstract class Shape implements IComparable {
    private boolean placedOnBoard;

    public Shape() {
        this.placedOnBoard = false;
    }

    public void setPlaced() {
        this.placedOnBoard = true;
    }

    public boolean placedOnBoard() {
        return this.placedOnBoard;
    }
}
