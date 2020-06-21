package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {

    @Test
    public void testCompareReturnTrueWhenShapesEqual() {
        Shape cross1 = new Cross();
        Shape cross2 = new Cross();

        boolean isEqual = cross1.compare(cross2);

        Assert.assertEquals(true, isEqual);
    }

    @Test
    public void testCompareReturnFalseWhenShapesDifferent() {
        Shape cross = new Cross();
        Shape circle = new Circle();

        boolean isEqual = cross.compare(circle);

        Assert.assertEquals(false, isEqual);
    }

    @Test
    public void testPlacedOnBoardReturnFalseWhenShapeHasNotYetBeenPlacedOnTheBoard() {
        Shape cross = new Cross();

        boolean placedOnBoard = cross.placedOnBoard();

        Assert.assertEquals(false, placedOnBoard);
    }
    
    @Test
    public void testPlacedOnBoardReturnTrueAfterPlacingShapeInTheCell(){
		Shape circle = new Circle();
		Cell cell = new Cell();
		cell.putShape(circle);
		
		boolean placedOnBoard = circle.placedOnBoard();
		
		Assert.assertEquals(true, placedOnBoard);
	}
	
    @Test
    public void testCheckingPlacedOnBoardTwiceReturnTrueAfterPlacingShapeInTheCell(){
		Shape circle = new Circle();
		boolean placedOnBoard = false;
		Cell cell = new Cell();
		cell.putShape(circle);
		
		placedOnBoard = circle.placedOnBoard();
		placedOnBoard = circle.placedOnBoard();
		
		Assert.assertEquals(true, placedOnBoard);
	}
}
