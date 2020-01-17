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

    public boolean checkForWinner(IShape aShape) {
        boolean res1 = this.cellList.get(0).compare(aShape);
        boolean res2 = this.cellList.get(1).compare(aShape);
        boolean res3 = this.cellList.get(2).compare(aShape);

        return (res1 && res2 && res3);
    }
}