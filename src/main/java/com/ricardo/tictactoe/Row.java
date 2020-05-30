package com.ricardo.tictactoe;

import com.ricardo.tictactoe.shape.Shape;

public class Row extends GridElement {

    public Row(int boardSize) {
        super(boardSize);
    }

    /**
     * Compares aShape with the shape stored on the cell which index is cellPos.
     * This is only used to iterate through the diagonals.
     *
     * @param aShape    shape which will be compared to the shape stored on the cell
     * @param cellPos   index of the cell
     * @return          return true if the shape stored on the cell is equal to aShape
     */
    public boolean compareWithShapeInCell(Shape aShape, int cellPos) {
        return this.cellList.get(cellPos).compare(aShape);
    }
}
