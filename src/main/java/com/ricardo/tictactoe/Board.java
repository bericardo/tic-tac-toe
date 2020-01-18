package com.ricardo.tictactoe;

import com.ricardo.tictactoe.shape.IShape;

import java.util.ArrayList;

public class Board {
    private final int BOARD_SIZE = 3;
    private ArrayList<Row> rowList;
    private ArrayList<Column> colList;

    public Board() {
        this.rowList = new ArrayList<Row>();
        this.colList = new ArrayList<Column>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            this.rowList.add(new Row(BOARD_SIZE));
            this.colList.add(new Column(BOARD_SIZE));
        }
    }

    public void putShape(IShape aShape, int rowPos, int colPos) {
        boolean rowInBounds = ((rowPos >= 0) && (rowPos < BOARD_SIZE));
        boolean colInBounds = ((colPos >= 0) && (colPos < BOARD_SIZE));

        if (!rowInBounds || !colInBounds) throw new InvalidPositionException();

        this.rowList.get(rowPos).putShape(aShape, colPos);
        this.colList.get(colPos).putShape(aShape, rowPos);
    }

    public boolean checkForWinners(IShape aShape) {

        boolean rowHasWinner = this.checkRows(aShape);
        boolean colHasWinner = this.checkColumns(aShape);
        boolean diag1HasWinner = this.checkFirstDiagonal(aShape);
        boolean diag2HasWinner = this.checkSecondDiagonal(aShape);

        return (rowHasWinner || colHasWinner || diag1HasWinner || diag2HasWinner);
    }

    private boolean checkRows(IShape aShape) {
        for (Row aRow : this.rowList) {
            if (aRow.checkForWinner(aShape)) return true;
        }
        return false;
    }

    private boolean checkColumns(IShape aShape) {
        for (Column aColumn : this.colList) {
            if (aColumn.checkForWinner(aShape)) return true;
        }
        return false;
    }

    private boolean checkFirstDiagonal(IShape aShape) {

        int cellPos = 0;
        for (Row aRow : this.rowList) {
            if (!aRow.compareWithShapeInCell(aShape, cellPos))
                return false;
            cellPos++;
        }

        return true;
    }

    private boolean checkSecondDiagonal(IShape aShape) {

        int cellPos = BOARD_SIZE - 1;
        for (Row aRow : this.rowList) {
            if (!aRow.compareWithShapeInCell(aShape, cellPos))
                return false;
            cellPos--;
        }
        return true;
    }
}
