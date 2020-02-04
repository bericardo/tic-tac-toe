package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.CellFree;
import com.ricardo.tictactoe.cell.CellTaken;
import com.ricardo.tictactoe.cell.ICellState;
import com.ricardo.tictactoe.cell.InvalidShapeException;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestCellState {

    // CELL FREE
    @Test
    public void testCompareReturnsAlwaysFalseWhenCellFree(){
        ICellState cellState  = new CellFree();
        Shape newShape = new Cross();
        Shape cellShape = null;

        boolean isEqual = cellState.compare(newShape, cellShape);

        Assert.assertEquals(false, isEqual);
    }

    @Test (expected = InvalidShapeException.class)
    public void testPuttingNullShapeInFreeCellReturnException(){
        ICellState cellState  = new CellFree();
        Shape newShape = null;
        Shape cellShape = null;

        cellState.putShape(newShape, cellShape);
    }

    @Test
    public void testWhenCellFreeAndShapeNotNullReturnNewShapeToBeStored(){
        ICellState cellState  = new CellFree();
        Shape newShape = new Cross();
        Shape cellShape = null;

        Shape shapeToBeStored = cellState.putShape(newShape, cellShape);

        Assert.assertEquals(shapeToBeStored, newShape);
    }

    //CELL TAKEN

    @Test
    public void testReturnTrueWhenShapeInCellEqualShapePassed(){
        ICellState cellState = new CellTaken();
        Shape newCell = new Cross();
        Shape cellShape = new Cross();

        boolean isEqual = cellState.compare(newCell, cellShape);

        Assert.assertEquals(true, isEqual);
    }

    @Test
    public void testReturnFalseWhenShapeInCellEqualShapePassed(){
        ICellState cellState = new CellTaken();
        Shape newCell = new Cross();
        Shape cellShape = new Circle();

        boolean isEqual = cellState.compare(newCell, cellShape);

        Assert.assertEquals(false, isEqual);
    }

    @Test
    public void testWhenCellTakenReturnShapeAlreadyStoredInCell(){
        ICellState cellState  = new CellTaken();
        Shape newShape = new Cross();
        Shape cellShape = new Circle();

        Shape shapeToBeStored = cellState.putShape(newShape, cellShape);

        Assert.assertEquals(shapeToBeStored, cellShape);
    }
}
