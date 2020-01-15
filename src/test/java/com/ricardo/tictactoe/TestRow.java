package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestRow {
    private final int SIZE = 3;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        int rowPosition = 4;

        row.putShape(cross, rowPosition);
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        int rowPosition = 3;
        boolean good = false;

        try{
            row.putShape(cross, rowPosition);
            good = true;
        } catch (Exception e) {
        }

        Assert.assertEquals(true, good);
    }

    @Test
    public void testAllColumnCellAreEmptyNoOneWinsReturnFalse(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();

        boolean gameOver = row.checkForWinner(cross);

        Assert.assertEquals(false, gameOver);
    }

    @Test
    public void testAllCellHaveTheSameShapeGameOverReturnTrue(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        row.putShape(cross, 0);
        row.putShape(cross, 1);
        row.putShape(cross, 2);

        boolean gameOver = row.checkForWinner(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testWhenCellHaveDifferentShapesNoOneWinsReturnFalse(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        IShape circle = new Circle();
        row.putShape(cross,0);
        row.putShape(circle, 1);
        row.putShape(cross, 2);

        boolean gameOver1 = row.checkForWinner(cross);
        boolean gameOver2 = row.checkForWinner(circle);
        boolean gameOverFinal = gameOver1 || gameOver2;

        Assert.assertEquals(false,gameOverFinal);
    }
}
