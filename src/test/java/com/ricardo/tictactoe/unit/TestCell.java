package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.cell.InvalidShapeException;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestCell {

    @Test
    public void testPlacingShapeInTakenCellDoesntOverrideShapeReturn() {
        Cell cell = new Cell();
        Shape cross = new Cross();
        Shape circle = new Circle();
        cell.putShape(cross);

        cell.putShape(circle);
        boolean sameShape = cell.compare(circle);

        Assert.assertEquals(false, sameShape);
    }

    @Test
    public void testReturnTrueIfCellStoredTheShapeWePut() {
        Cell cell = new Cell();
        Shape cross = new Cross();

        cell.putShape(cross);
        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(true, sameShape);
    }

    @Test
    public void testComparingAnyShapeWithEmptyCellReturnFalse() {
        Cell cell = new Cell();
        Shape cross = new Cross();

        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(false, sameShape);
    }

    @Test(expected = InvalidShapeException.class)
    public void testPlacingNullShapeInFreeCellThrowException() {
        Cell cell = new Cell();
        Shape cross = null;

        cell.putShape(cross);
    }

    @Test(expected = InvalidShapeException.class)
    public void testComparingShapeStoredInCellWithNullShapeThrowException() {
        Cell cell = new Cell();
        Shape cross = new Cross();
        Shape circle = null;
        cell.putShape(cross);

        cell.compare(circle);
    }

    @Test
    public void testShapeSettedToTrueIfCellFree() {
        Cell cell = new Cell();
        Shape cross = new Cross();

        cell.putShape(cross);
        boolean placed = cross.placedOnBoard();

        Assert.assertEquals(true, placed);
    }

    @Test
    public void testPlacedOnBoardReturnFalseIfCellTaken() {
        Cell cell = new Cell();
        Shape cross = new Cross();
        Shape circle = new Circle();
        cell.putShape(circle);
        cell.putShape(cross);

        boolean placed = cross.placedOnBoard();

        Assert.assertEquals(false, placed);
    }
}
