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
        Ishape cross = new Cross();

        cell.putShape(cross);
        boolean free = cell.isFree();

        Assert.assertEquals(false, free);
    }
}
