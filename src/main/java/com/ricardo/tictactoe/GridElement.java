package com.ricardo.tictactoe;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.shape.Shape;

import java.util.ArrayList;

/**
 * Represents a set of cells. This could be a row or a column.
 */
public abstract class GridElement {
    protected ArrayList<Cell> cellList;

    public GridElement(int boardSize) {
        this.cellList = new ArrayList<Cell>();

        for (int i = 0; i < boardSize; i++)
            this.cellList.add(new Cell());
    }

    /**
     * Puts a shape on a specified cell
     *
     * @param aShape    shape (Cross or Circle) to be stored on the cell
     * @param cellPos   index of the cell where the aShape will be put
     */
    public void putShape(Shape aShape, int cellPos) {
        Cell cell = this.cellList.get(cellPos);
        cell.putShape(aShape);
    }

    /**
     * Compares every cell's shape with aShape
     *
     * @param aShape    shape to be compared with the shape stored on every cell
     * @return          true if every cell has a shape equal to aShape
     */
    public boolean checkForWinner(Shape aShape) {
        for (Cell aCell : this.cellList) {
            if (!aCell.compare(aShape)) return false;
        }
        return true;
    }
}
