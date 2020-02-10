package com.ricardo.tictactoe;

import com.ricardo.tictactoe.shape.Shape;

public class Row extends GridElement {

    public Row(int boardSize) {
        super(boardSize);
    }

    public boolean compareWithShapeInCell(Shape aShape, int cellPos) {
        return this.cellList.get(cellPos).compare(aShape);
    }
}
