package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.cell.InvalidShapeException;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestCell {
    @Test
    public void testANewCellIsAlwaysFreeReturnTrue() {
        Cell cell = new Cell();

        boolean free = cell.forTest_isFree();

        Assert.assertEquals(true, free);
    }

    @Test
    public void testCellIsNotFreeWhenHasShapeReturnFalse() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        cell.putShape(cross);

        boolean free = cell.forTest_isFree();

        Assert.assertEquals(false, free);
    }

    @Test
    public void testPuttingNewShapeOnCellWhichHasAShapeDoesntChangeShapeAlreadyStored() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        IShape circle = new Circle();
        cell.putShape(cross);
        cell.putShape(circle);

        boolean sameShape = cell.compare(circle);

        Assert.assertEquals(false, sameShape);
    }

    @Test
    public void testPutShapeInFreeCellStoresThatShapeReturnTrue() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        cell.putShape(cross);

        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(true, sameShape);
    }

    @Test
    public void testComparingShapeWithEmptyCellReturnFalse() {
        Cell cell = new Cell();
        IShape cross = new Cross();

        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(false, sameShape);
    }

    @Test(expected = InvalidShapeException.class)
    public void testPlacingShapePointingToNullThrowException() {
        Cell cell = new Cell();
        IShape cross = null;

        cell.putShape(cross);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCompareShapeWhichIsNullThrowException() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        IShape circle = null;
        cell.putShape(cross);

        cell.compare(circle);
    }
}
