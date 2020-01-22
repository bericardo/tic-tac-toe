package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.Column;
import com.ricardo.tictactoe.Row;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestColumn {
    private final int BOARD_SIZE = 3;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException() {
        Column col = new Column(this.BOARD_SIZE);
        IShape cross = new Cross();
        int colPosition = 4;

        col.putShape(cross, colPosition);
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException() {
        Column col = new Column(this.BOARD_SIZE);
        IShape cross = new Cross();
        int colPosition = 2;
        boolean validPosition = false;

        try {
            col.putShape(cross, colPosition);
            validPosition = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true, validPosition);
    }

    @Test
    public void testAllColumnCellAreEmptyNoOneWinsReturnFalse() {
        Column col = new Column(this.BOARD_SIZE);
        IShape cross = new Cross();

        boolean gameOver = col.checkForWinner(cross);

        Assert.assertEquals(false, gameOver);
    }

    @Test
    public void testAllCellHaveTheSameShapeGameOverReturnTrue() {
        Column col = new Column(this.BOARD_SIZE);
        IShape cross = new Cross();
        col.putShape(cross, 0);
        col.putShape(cross, 1);
        col.putShape(cross, 2);

        boolean gameOver = col.checkForWinner(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testWhenCellHaveDifferentShapesNoOneWinsReturnFalse() {
        Column col = new Column(this.BOARD_SIZE);
        IShape cross = new Cross();
        IShape circle = new Circle();
        col.putShape(cross, 0);
        col.putShape(circle, 1);
        col.putShape(cross, 2);

        boolean gameOver1 = col.checkForWinner(cross);
        boolean gameOver2 = col.checkForWinner(circle);
        boolean gameOverFinal = gameOver1 || gameOver2;

        Assert.assertEquals(false, gameOverFinal);
    }

    @Test
    public void testIfShapeWasSuccessfullyPlacedReturnTrue(){
        Column col = new Column(this.BOARD_SIZE);
        Cross cross = new Cross();

        boolean shapePlaced = col.putShape(cross, 0);

        Assert.assertEquals(true, shapePlaced);
    }
}
