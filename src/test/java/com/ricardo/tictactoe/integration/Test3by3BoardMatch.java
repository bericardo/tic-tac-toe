package com.ricardo.tictactoe.integration;
import com.ricardo.tictactoe.Board;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class Test3by3BoardMatch {

    @Test
    public void testMatchCircleVsCrossWhereCircleWinsBoardIsNotFilled(){
        Board board = new Board();
        Shape cross = new Cross();
        Shape circle = new Circle();
        boolean gameOver = false;
        boolean boardFilled = false;

        board.putShape(cross, 0,1);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);

        board.putShape(circle, 1,1);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);

        board.putShape(cross, 2,0);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);

        board.putShape(circle, 2,2);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);

        board.putShape(cross, 1,2);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);

        board.putShape(circle, 0,0);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();

        Assert.assertEquals(true, gameOver);
        Assert.assertEquals(false, boardFilled);
    }

    @Test
    public void testDrawGameMatchCircleVsCrossBoardIsFilled(){
        Board board = new Board();
        Shape cross = new Cross();
        Shape circle = new Circle();
        boolean gameOver = false;
        boolean boardFilled = false;
        boolean drawGame = false;

        board.putShape(circle, 0,0);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(cross, 0,1);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);
        
        board.putShape(circle, 0,2);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(circle, 1,0);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(cross, 1,1);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(cross, 1,2);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(cross, 2,0);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(circle, 2,1);
        gameOver = board.checkForWinners(circle);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(false, boardFilled);
        Assert.assertEquals(false, drawGame);

        board.putShape(cross, 2,2);
        gameOver = board.checkForWinners(cross);
        boardFilled = board.isFilled();
        drawGame = (!gameOver && boardFilled);

        Assert.assertEquals(false, gameOver);
        Assert.assertEquals(true, boardFilled);
        Assert.assertEquals(true, drawGame);
    }
}
