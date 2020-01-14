package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestColumn {
    private final int SIZE = 3;

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPuttingShapeInInvalidPositionThrowException(){
        Column col = new Column(SIZE);
        IShape cross = new Cross();
        int colPosition = 4;

        try {
            col.putShape(cross, colPosition);
            Assert.assertTrue(false);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Test
    public void testPuttingShapeInValidPositionDoesntThrowException(){
        Column col = new Column(SIZE);
        IShape cross = new Cross();
        int colPosition = 3;

        try{
            col.putShape(cross, colPosition);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
