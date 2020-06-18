package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.Column;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestColumn {
    private final int BOARD_SIZE = 3;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException() {
        Column col = new Column(this.BOARD_SIZE);
        Shape cross = new Cross();
        int colPosition = 4;

        col.putShape(cross, colPosition);
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException() {
        Column col = new Column(this.BOARD_SIZE);
        Shape cross = new Cross();
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
    public void testCheckForWinnerReturnFalseWhenEveryColumnCellIsEmpty() {
        Column col = new Column(this.BOARD_SIZE);
        Shape cross = new Cross();

        boolean crossHasWon = col.checkForWinner(cross);

        Assert.assertEquals(false, crossHasWon);
    }

    @Test
    public void testCheckForWinnerReturnTrueWhenARowHasTheSameShapeInEachColumn() {
        Column col = new Column(this.BOARD_SIZE);
        Shape cross = new Cross();
        col.putShape(cross, 0);
        col.putShape(cross, 1);
        col.putShape(cross, 2);

        boolean crossHasWon = col.checkForWinner(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test
    public void testCheckForWinnerReturnFalseWhenARowHasDifferentShapesInEachColumn() {
        Column col = new Column(this.BOARD_SIZE);
        Shape cross = new Cross();
        Shape circle = new Circle();
        col.putShape(cross, 0);
        col.putShape(circle, 1);
        col.putShape(cross, 2);

        boolean crossHasWon = col.checkForWinner(cross);
        boolean circleHasWon = col.checkForWinner(circle);
        boolean crossOrCircleHasWon = crossHasWon || circleHasWon;

        Assert.assertEquals(false, crossOrCircleHasWon);
    }
}
