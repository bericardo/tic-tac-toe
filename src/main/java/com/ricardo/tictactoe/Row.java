package com.ricardo.tictactoe;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.shape.Shape;

import java.util.ArrayList;

public class Row {
    private ArrayList<Cell> cellList;

    public Row(int boardSize) {
        this.cellList = new ArrayList<Cell>();

        for (int i = 0; i < boardSize; i++)
            this.cellList.add(new Cell());
    }

    public void putShape(Shape aShape, int cellPos) {
        Cell cell = this.cellList.get(cellPos);
        cell.putShape(aShape);
    }

    public boolean checkForWinner(Shape aShape) {
        for (Cell aCell : this.cellList) {
            if (!aCell.compare(aShape)) return false;
        }
        return true;
    }

    /*
     * Used for comparing a given shape with a specific cell of a Row.
     * This is used only to check if one of the two diagonals have the
     * same shape.
    */
    public boolean compareWithShapeInCell(Shape aShape, int cellPos) {
        return this.cellList.get(cellPos).compare(aShape);
    }
}
