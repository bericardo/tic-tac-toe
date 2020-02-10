package com.ricardo.tictactoe;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.shape.Shape;

import java.util.ArrayList;

public abstract class GridElement {
    protected ArrayList<Cell> cellList;

    public GridElement(int boardSize) {
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
}
