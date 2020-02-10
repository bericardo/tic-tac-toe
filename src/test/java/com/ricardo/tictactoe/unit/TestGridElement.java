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
    public void testAllColumnCellAreEmptyNoOneWinsReturnFalse() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();

        boolean gameOver = row.checkForWinner(cross);

        Assert.assertEquals(false, gameOver);
    }

    @Test
    public void testAllCellHaveTheSameShapeGameOverReturnTrue() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        row.putShape(cross, 0);
        row.putShape(cross, 1);
        row.putShape(cross, 2);

        boolean gameOver = row.checkForWinner(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testWhenCellHaveDifferentShapesNoOneWinsReturnFalse() {
        GridElement row = new Row(this.BOARD_SIZE);
        Shape cross = new Cross();
        Shape circle = new Circle();
        row.putShape(cross, 0);
        row.putShape(circle, 1);
        row.putShape(cross, 2);

        boolean gameOver1 = row.checkForWinner(cross);
        boolean gameOver2 = row.checkForWinner(circle);
        boolean gameOverFinal = gameOver1 || gameOver2;

        Assert.assertEquals(false, gameOverFinal);
    }
}
