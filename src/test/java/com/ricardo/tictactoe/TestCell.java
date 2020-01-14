package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestCell {
    @Test
    public void testNewCellIsFreeReturnTrue(){
        Cell cell = new Cell();

        boolean free = cell.isFree();

        Assert.assertEquals(true, free);
    }

    @Test
    public void testCellIsNotFreeWhenHasShapeReturnFalse(){
        Cell cell = new Cell();
        IShape cross = new Cross();

        cell.putShape(cross);
        boolean free = cell.isFree();

        Assert.assertEquals(false, free);
    }

    @Test
    public void testPuttingNewShapeOnCellWhichHasAShapeDoesntChangeShapeAlreadyStored(){
     Cell cell = new Cell();
     IShape cross = new Cross();
     IShape circle = new Circle();

     cell.putShape(cross);
     cell.putShape(circle);
     boolean sameShape = cell.compare(circle);

     Assert.assertEquals(false, sameShape);
    }

    @Test
    public void testPutShapeInFreeCellStoresThatShapeReturnTrue(){
        Cell cell = new Cell();
        IShape cross = new Cross();

        cell.putShape(cross);
        boolean sameShape = cell.compare(cross);

        Assert.assertEquals(true, sameShape);
    }
}
