package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.Board;
import com.ricardo.tictactoe.InvalidPositionException;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestBoard {

    @Test
    public void testPlacingSameShapeOnARowWinsGameReturnTrue(){
        Board board = new Board();
        IShape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(cross, 0, 1);
        board.putShape(cross, 0, 2);

        boolean gameOver = board.checkForWinners(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testPlacingSameShapeOnAColumnWinsGameReturnTrue(){
        Board board = new Board();
        IShape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(cross, 1, 0);
        board.putShape(cross, 2, 0);

        boolean gameOver = board.checkForWinners(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testPlacingSameShapeOnFirstDiagonalWinsMatchReturnTrue(){
        Board board = new Board();
        IShape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(cross, 1, 1);
        board.putShape(cross, 2, 2);

        boolean gameOver = board.checkForWinners(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test
    public void testPlacingSameShapeOnSecondDiagonalWinsMatchReturnTrue(){
        Board board = new Board();
        IShape cross = new Cross();
        board.putShape(cross, 0, 2);
        board.putShape(cross, 1, 1);
        board.putShape(cross, 2, 0);

        boolean gameOver = board.checkForWinners(cross);

        Assert.assertEquals(true, gameOver);
    }

    @Test (expected = InvalidPositionException.class)
    public void testPassingCellPositionGreaterThan2ThrowException(){
        Board board = new Board();
        IShape cross = new Cross();

        board.putShape(cross, 3, 3);
    }

    @Test (expected = InvalidPositionException.class)
    public void testPassingCellPositionLessThan0ThrowException(){
        Board board = new Board();
        IShape cross = new Cross();

        board.putShape(cross, -1, -1);
    }

    @Test
    public void testCheckingForWinnersOnEmptyBoardReturnFalse(){
        Board board = new Board();

        boolean thereIsAWinner = board.checkForWinners(new Cross());

        Assert.assertEquals(false, thereIsAWinner);
    }
}
