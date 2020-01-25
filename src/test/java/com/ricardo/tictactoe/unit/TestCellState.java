package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.CellFree;
import com.ricardo.tictactoe.cell.ICellState;
import com.ricardo.tictactoe.cell.InvalidShapeException;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestCellState {

    @Test
    public void testCompareReturnsAlwaysFalseWhenCellFree(){
        ICellState cell  = new CellFree();
        IShape newShape = new Cross();
        IShape cellShape = null;

        boolean isEqual = cell.compare(newShape, cellShape);

        Assert.assertEquals(false, isEqual);
    }

    @Test (expected = InvalidShapeException.class)
    public void testPuttingNullShapeInFreeCellReturnException(){
        ICellState cell  = new CellFree();
        IShape newShape = null;
        IShape cellShape = null;

        cell.putShape(newShape, cellShape);
    }

    @Test
    public void testWhellCellFreeAndShapeNotNullReturnNewShapeToBeStored(){
        ICellState cell  = new CellFree();
        IShape newShape = new Cross();
        IShape cellShape = null;

        IShape shapeToBeStored = cell.putShape(newShape, cellShape);

        Assert.assertEquals(shapeToBeStored, newShape);
    }
}
