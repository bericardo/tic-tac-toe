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
    public void testPutShapeInFreeCellReturnTrue(){
        Cell cell = new Cell();
        Cross cross = new Cross();

        boolean shapePlacedSuccessfully = cell.putShape(cross);

        Assert.assertEquals(true, shapePlacedSuccessfully);
    }
    @Test
    public void testPutShapeInTakenCellReturnFalse(){
        Cell cellTaken = new Cell();
        Cross cross = new Cross();

        boolean shapePlacedSuccessfully = cellTaken.putShape(cross);

        Assert.assertEquals(true, shapePlacedSuccessfully);
    }

    @Test
    public void testPlacingShapeInTakenCellDoesntOverrideShapeReturn() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        IShape circle = new Circle();
        cell.putShape(cross);

        cell.putShape(circle);
        boolean sameShape = cell.compare(circle);

        Assert.assertEquals(false, sameShape);
    }

    @Test
    public void testReturnTrueIfCellStoredTheShapeWePut() {
        Cell cell = new Cell();
        IShape cross = new Cross();

        cell.putShape(cross);
        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(true, sameShape);
    }

    @Test
    public void testComparingAnyShapeWithEmptyCellReturnFalse() {
        Cell cell = new Cell();
        IShape cross = new Cross();

        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(false, sameShape);
    }

    @Test(expected = InvalidShapeException.class)
    public void testPlacingNullShapeInFreeCellThrowException() {
        Cell cell = new Cell();
        IShape cross = null;

        cell.putShape(cross);
    }

    @Test(expected = InvalidShapeException.class)
    public void testComparingShapeStoredInCellWithNullShapeThrowException() {
        Cell cell = new Cell();
        IShape cross = new Cross();
        IShape circle = null;
        cell.putShape(cross);

        cell.compare(circle);
    }
}
