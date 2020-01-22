package com.ricardo.tictactoe;

import com.ricardo.tictactoe.shape.IShape;

import java.util.ArrayList;

public class Board {
    private static final int BOARD_SIZE = 3;
    private int shapeCounter;
    private ArrayList<Row> rowList;
    private ArrayList<Column> colList;

    public Board() {
        this.shapeCounter = 0;
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

        boolean shapePlacedSuccessfuly = this.rowList.get(rowPos).putShape(aShape, colPos);
        this.colList.get(colPos).putShape(aShape, rowPos);

        if(shapePlacedSuccessfuly){
            this.shapeCounter++;
        }
    }

    public boolean checkForWinners(IShape aShape) {

        boolean rowHasWinner = this.checkRows(aShape);
        boolean colHasWinner = this.checkColumns(aShape);
        boolean diag1HasWinner = this.checkFirstDiagonal(aShape);
        boolean diag2HasWinner = this.checkSecondDiagonal(aShape);

        return (rowHasWinner || colHasWinner || diag1HasWinner || diag2HasWinner);
    }

    public boolean isFilled() {
        return (this.shapeCounter == BOARD_SIZE*BOARD_SIZE);
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

    /*
    * In a matrix, the positions being checked here would be
    * (i,i) for i=1,2,3 but in this case are (j,j) for j=0,1,2
    */
    private boolean checkFirstDiagonal(IShape aShape) {

        int cellPos = 0;
        for (Row aRow : this.rowList) {
            if (!aRow.compareWithShapeInCell(aShape, cellPos))
                return false;
            cellPos++;
        }

        return true;
    }

    /*
     * In a matrix, the positions being checked here would be
     * (1,3),(2,2),(3,1) but in this case are (0,2),(1,1),(2,0)
     */
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
