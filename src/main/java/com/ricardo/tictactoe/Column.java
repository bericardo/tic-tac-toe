package com.ricardo.tictactoe;

import java.util.ArrayList;

public class Column {

    private ArrayList<Cell> cellList = new ArrayList<Cell>();

    public Column(int size) {
        for(int i = 0; i <= size; i++)
            this.cellList.add(new Cell());
    }

    public void putShape(IShape aShape, int position) {
        Cell cell = this.cellList.get(position);
        cell.putShape(aShape);
    }

    public boolean checkForWinner(IShape aShape) {
        boolean res1 = this.cellList.get(0).compare(aShape);
        boolean res2 = this.cellList.get(1).compare(aShape);
        boolean res3 = this.cellList.get(2).compare(aShape);

        return (res1 && res2 && res3);
    }
}
