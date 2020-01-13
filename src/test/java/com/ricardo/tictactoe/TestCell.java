package com.ricardo.tictactoe;

public class testCell {
    @Test
    public void testFreeCellReturnTrue(){
        Cell cell = new Cell();

        boolean free = cell.isFree();

        Assert.assertEquals(true, free);
    }
}
