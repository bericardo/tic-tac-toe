package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestRow {
    private final int SIZE = 3;

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        int rowPosition = 4;

        row.putShape(cross, rowPosition);
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException(){
        Row row = new Row(this.SIZE);
        IShape cross = new Cross();
        int rowPosition = 3;
        boolean good = false;

        try{
            row.putShape(cross, rowPosition);
            good = true;
        } catch (Exception e) {
        }

        Assert.assertEquals(true, good);
    }
}
