package com.ricardo.tictactoe;

import java.util.ArrayList;

public class Row {
    private ArrayList<Cell> cellList;

    public Row(int size) {
        this.cellList = new ArrayList<Cell>();

        for(int i = 0; i <= size; i++)
            this.cellList.add(new Cell());
    }

    public void putShape(IShape aShape, int rowPosition) {
        Cell cell = this.cellList.get(rowPosition);
        cell.putShape(aShape);
    }
}