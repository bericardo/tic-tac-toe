package com.ricardo.tictactoe;

import com.ricardo.tictactoe.shape.Shape;

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
    
    /**
    * @param aShape shape to be placed on the board
    * @param rowPos row position where aShape will be placed
    * @param colPos column position where aShape will be placed
    */
    public void putShape(Shape aShape, int rowPos, int colPos) {
        boolean rowInBounds = ((rowPos >= 0) && (rowPos < BOARD_SIZE));
        boolean colInBounds = ((colPos >= 0) && (colPos < BOARD_SIZE));

        if (!rowInBounds || !colInBounds) throw new InvalidPositionException();

        this.rowList.get(rowPos).putShape(aShape, colPos);
        this.colList.get(colPos).putShape(aShape, rowPos);

        if(aShape.placedOnBoard()) this.shapeCounter++;
    }

    /**
    * @param aShape last shape placed on the board
    * @return true if aShape won the match
    */
    public boolean checkForWinners(Shape aShape) {

        boolean rowHasWinner = this.checkRows(aShape);
        boolean colHasWinner = this.checkColumns(aShape);
        boolean diag1HasWinner = this.checkFirstDiagonal(aShape);
        boolean diag2HasWinner = this.checkSecondDiagonal(aShape);

        return (rowHasWinner || colHasWinner || diag1HasWinner || diag2HasWinner);
    }

    /**
    * @return true if the board is completely filled
    */
    public boolean isFilled() {
        return (this.shapeCounter == BOARD_SIZE*BOARD_SIZE);
    }

    /**
    * @param aShape shape which will be compared with every cell's shape
    * @return true if every cell of one row contain a shape equal to aShape
    */
    private boolean checkRows(Shape aShape) {
        for (Row aRow : this.rowList) {
            if (aRow.checkForWinner(aShape)) return true;
        }
        return false;
    }

    
    /**
    * @param aShape shape which will be compared with every cell's shape
    * @return true if every cell of one column contain a shape equal to aShape
    */
    private boolean checkColumns(Shape aShape) {
        for (Column aColumn : this.colList) {
            if (aColumn.checkForWinner(aShape)) return true;
        }
        return false;
    }

    /**
    * The positions being checked here are (j,j) where j=0,1,2
    *
    * @param aShape shape which will be compared with every cell's shape
    * @return true if every cell of the diagonal contain a shape equal to aShape
    */
    private boolean checkFirstDiagonal(Shape aShape) {

        int cellPos = 0;
        for (Row aRow : this.rowList) {
            if (!aRow.compareWithShapeInCell(aShape, cellPos))
                return false;
            cellPos++;
        }

        return true;
    }

     /**
     * The positions being checked here are (0,2),(1,1),(2,0).
     *
     * @param aShape shape which will be compared with every cell's shape
     * @return true if every cell of the diagonal contain a shape equal to aShape
     */
    private boolean checkSecondDiagonal(Shape aShape) {

        int cellPos = BOARD_SIZE - 1;
        for (Row aRow : this.rowList) {
            if (!aRow.compareWithShapeInCell(aShape, cellPos))
                return false;
            cellPos--;
        }
        return true;
    }
}
