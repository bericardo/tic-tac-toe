package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.Board;
import com.ricardo.tictactoe.InvalidPositionException;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestBoard {

    @Test
    public void testPlacingSameShapeOnARowWinsMatchReturnTrue() {
        Board board = new Board();
        Shape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(new Cross(), 0, 1);
        board.putShape(new Cross(), 0, 2);

        boolean crossHasWon = board.checkForWinners(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test
    public void testPlacingSameShapeOnAColumnWinsMatchReturnTrue() {
        Board board = new Board();
        Shape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(new Cross(), 1, 0);
        board.putShape(new Cross(), 2, 0);

        boolean crossHasWon = board.checkForWinners(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test
    public void testPlacingSameShapeOnFirstDiagonalWinsMatchReturnTrue() {
        Board board = new Board();
        Shape cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(new Cross(), 1, 1);
        board.putShape(new Cross(), 2, 2);

        boolean crossHasWon = board.checkForWinners(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test
    public void testPlacingSameShapeOnSecondDiagonalWinsMatchReturnTrue() {
        Board board = new Board();
        Shape cross = new Cross();
        board.putShape(cross, 0, 2);
        board.putShape(new Cross(), 1, 1);
        board.putShape(new Cross(), 2, 0);

        boolean crossHasWon = board.checkForWinners(cross);

        Assert.assertEquals(true, crossHasWon);
    }

    @Test(expected = InvalidPositionException.class)
    public void testPassingPositionGreaterThanBoardSizeThrowException() {
        Board board = new Board();
        Shape cross = new Cross();

        board.putShape(cross, 3, 3);
    }

    @Test(expected = InvalidPositionException.class)
    public void testPassingNegativePositionThrowException() {
        Board board = new Board();
        Shape cross = new Cross();

        board.putShape(cross, -1, -1);
    }

    @Test
    public void testCheckForWinnersReturnFalseWhenBoardIsEmpty() {
        Board board = new Board();
        Shape cross = new Cross();

        boolean crossHasWon = board.checkForWinners(cross);

        Assert.assertEquals(false, crossHasWon);
    }

    @Test
    public void testIsFilledReturnFalseWhenBoardIsEmpty() {
        Board board = new Board();

        boolean filled = board.isFilled();

        Assert.assertEquals(false, filled);
    }

    @Test
    public void testIsFilledReturnFalseWhenBoardHasOnlyOneShape() {
        Board board = new Board();
        Circle circle = new Circle();
        board.putShape(circle, 0, 0);

        boolean filled = board.isFilled();

        Assert.assertEquals(false, filled);
    }

    @Test
    public void testIsFilledReturnTrueWhenBoardIsCompletelyFilled() {
        Board board = new Board();
        Cross cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(new Cross(), 0, 1);
        board.putShape(new Cross(), 0, 2);
        board.putShape(new Cross(), 1, 0);
        board.putShape(new Cross(), 1, 1);
        board.putShape(new Cross(), 1, 2);
        board.putShape(new Cross(), 2, 0);
        board.putShape(new Cross(), 2, 1);
        board.putShape(new Cross(), 2, 2);

        boolean filled = board.isFilled();

        Assert.assertEquals(true, filled);
    }
    
    @Test
    public void testPlacingAShapeOnTopOfOtherShapeShouldNotIncreaseTheShapeCounter() {
        Board board = new Board();
        Cross cross = new Cross();
        board.putShape(cross, 0, 0);
        board.putShape(new Cross(), 0, 1);
        board.putShape(new Cross(), 0, 2);
        board.putShape(new Cross(), 1, 0);
        board.putShape(new Cross(), 1, 1);
        board.putShape(new Cross(), 1, 2);
        board.putShape(new Cross(), 2, 0);
        board.putShape(new Cross(), 2, 1);
        board.putShape(new Cross(), 2, 1);

        boolean filled = board.isFilled();

        Assert.assertEquals(false, filled);
	}
}
