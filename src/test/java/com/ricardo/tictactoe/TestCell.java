package com.ricardo.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TestCell {
    @Test
    public void testNewCellsAreAlwaysFreeReturnTrue(){
        Cell cell = new Cell();

        boolean free = cell.isFree();

        Assert.assertEquals(true, free);
    }
}
