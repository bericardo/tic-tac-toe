package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.cell.CellFree;
import com.ricardo.tictactoe.cell.CellTaken;
import com.ricardo.tictactoe.cell.ICellState;
import com.ricardo.tictactoe.cell.InvalidShapeException;
import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestCellState {

    // CELL FREE
    @Test
    public void testCompareReturnsAlwaysFalseWhenCellFree(){
        ICellState cellState  = new CellFree();
        IShape newShape = new Cross();
        IShape cellShape = null;

        boolean isEqual = cellState.compare(newShape, cellShape);

        Assert.assertEquals(false, isEqual);
    }

    @Test (expected = InvalidShapeException.class)
    public void testPuttingNullShapeInFreeCellReturnException(){
        ICellState cellState  = new CellFree();
        IShape newShape = null;
        IShape cellShape = null;

        cellState.putShape(newShape, cellShape);
    }

    @Test
    public void testWhenCellFreeAndShapeNotNullReturnNewShapeToBeStored(){
        ICellState cellState  = new CellFree();
        IShape newShape = new Cross();
        IShape cellShape = null;

        IShape shapeToBeStored = cellState.putShape(newShape, cellShape);

        Assert.assertEquals(shapeToBeStored, newShape);
    }

    //CELL TAKEN

    @Test
    public void testReturnTrueWhenShapeInCellEqualShapePassed(){
        ICellState cellState = new CellTaken();
        IShape newCell = new Cross();
        IShape cellShape = new Cross();

        boolean isEqual = cellState.compare(newCell, cellShape);

        Assert.assertEquals(true, isEqual);
    }

    @Test
    public void testReturnFalseWhenShapeInCellEqualShapePassed(){
        ICellState cellState = new CellTaken();
        IShape newCell = new Cross();
        IShape cellShape = new Circle();

        boolean isEqual = cellState.compare(newCell, cellShape);

        Assert.assertEquals(false, isEqual);
    }

    @Test
    public void testWhenCellTakenReturnShapeAlreadyStoredInCell(){
        ICellState cellState  = new CellTaken();
        IShape newShape = new Cross();
        IShape cellShape = new Circle();

        IShape shapeToBeStored = cellState.putShape(newShape, cellShape);

        Assert.assertEquals(shapeToBeStored, cellShape);
    }
}
