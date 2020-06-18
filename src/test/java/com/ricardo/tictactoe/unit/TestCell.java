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
    public void testShapeIsNotPlacedWhenCellIsOccupied() {
        Cell cell = new Cell();
        Shape cross = new Cross();
        Shape circle = new Circle();
        cell.putShape(cross);

        cell.putShape(circle);
        boolean cellHasACircleShape = cell.compare(circle);

        Assert.assertEquals(false, cellHasACircleShape);
    }

    @Test
    public void testShapeIsSuccessfulyPlacedWhenCellIsFree() {
        Cell cell = new Cell();
        Shape cross = new Cross();

        cell.putShape(cross);
        boolean cellHasCrossShape = cell.compare(cross);

        Assert.assertEquals(true, cellHasCrossShape);
    }

    @Test
    public void testCellInstanceIsIntiallyEmpty() {
        Cell cell = new Cell();
        Shape cross = new Cross();

        boolean cellHasCrossShape = cell.compare(cross);

        Assert.assertEquals(false, cellHasCrossShape);
    }

    @Test(expected = InvalidShapeException.class)
    public void testPutShapeThrowExceptionWhenShapeIsNull() {
        Cell cell = new Cell();
        Shape cross = null;

        cell.putShape(cross);
    }
}
