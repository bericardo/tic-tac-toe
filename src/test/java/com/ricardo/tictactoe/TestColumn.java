package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestColumn {
    private final int SIZE = 3;

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException(){
        Column col = new Column(this.SIZE);
        IShape cross = new Cross();
        int colPosition = 4;

        try {
            col.putShape(cross, colPosition);
            Assert.assertTrue(false);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException(){
        Column col = new Column(this.SIZE);
        IShape cross = new Cross();
        int colPosition = 3;

        try{
            col.putShape(cross, colPosition);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAllColumnCellAreEmptyNoOneWinsReturnFalse(){
        Column col = new Column(this.SIZE);
        IShape cross = new Cross();

        boolean gameOver = col.checkForWinner(cross);

        Assert.assertEquals(false, gameOver);
    }

    @Test
    public void testAllCellHaveTheSameShapeGameOverReturnTrue(){
        Column col = new Column(this.SIZE);
        IShape cross = new Cross();
        col.putShape(cross, 0);
        col.putShape(cross, 1);
        col.putShape(cross, 2);

        boolean gameOver = col.checkForWinner(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testWhenCellHaveDifferentShapesNoOneWinsReturnFalse(){
        Column col = new Column(this.SIZE);
        IShape cross = new Cross();
        IShape circle = new Circle();
        col.putShape(cross,0);
        col.putShape(circle, 1);
        col.putShape(cross, 2);

        boolean gameOver1 = col.checkForWinner(cross);
        boolean gameOver2 = col.checkForWinner(circle);
        boolean gameOverFinal = gameOver1 || gameOver2;

        Assert.assertEquals(false,gameOverFinal);
    }
}
