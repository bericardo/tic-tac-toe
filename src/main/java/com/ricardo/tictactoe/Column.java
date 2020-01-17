package com.ricardo.tictactoe;

import com.ricardo.tictactoe.cell.Cell;
import com.ricardo.tictactoe.shape.IShape;

import java.util.ArrayList;

public class Column {

    private ArrayList<Cell> cellList;

    public Column(int size) {
        this.cellList = new ArrayList<Cell>();

        for (int i = 0; i < size; i++)
            this.cellList.add(new Cell());
    }

    public void putShape(IShape aShape, int cellPos) {
        Cell cell = this.cellList.get(cellPos);
        cell.putShape(aShape);
    }

    public boolean checkForWinner(IShape aShape) {
        for(Cell aCell : this.cellList) {
            if (aCell.compare(aShape) == false) return false;
        }
        return true;
    }
}
