package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.GridElement;
import com.ricardo.tictactoe.Row;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestGridElement {
    private final int BOARD_SIZE = 3;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        int rowPosition = 4;

        row.putShape(cross, rowPosition);
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        int rowPosition = 2;
        boolean validPosition = false;

        try {
            row.putShape(cross, rowPosition);
            validPosition = true;
        } catch (Exception e) {
        }

        Assert.assertEquals(true, validPosition);
    }

    @Test
    public void testCheckForWinnerReturnFalseWhenEveryCellIsEmpty() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();

        boolean crossHasWon = row.checkForWinner(cross);

        Assert.assertEquals(false, crossHasWon);
    }

    @Test
    public void testCheckForWinnerReturnTrueWhenEveryCellHasTheSameShape() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        row.putShape(cross, 0);
        row.putShape(new Cross(), 1);
        row.putShape(new Cross(), 2);

        boolean crossHasWon = row.checkForWinner(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test
    public void testCheckForWinnerReturnFalseWhenCellsHaveDifferentShape() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        Shape circle = new Circle();
        row.putShape(cross, 0);
        row.putShape(circle, 1);
        row.putShape(new Cross(), 2);

        boolean crossHasWon = row.checkForWinner(cross);
        boolean circleHasWon = row.checkForWinner(circle);
        boolean crossOrCircleHasWon = crossHasWon || circleHasWon;

        Assert.assertEquals(false, crossOrCircleHasWon);
    }
}
