package com.ricardo.tictactoe;

import java.util.ArrayList;

public class Board {
    private final int BOARD_SIZE = 3;
    private ArrayList<Row> rowList;
    private ArrayList<Column> colList;

    public Board(){
        this.rowList = new ArrayList<Row>();
        this.colList = new ArrayList<Column>();

        for(int i = 0; i <= BOARD_SIZE; i++){
            this.rowList.add(new Row(BOARD_SIZE));
            this.colList.add(new Column(BOARD_SIZE));
        }
    }

    public void putShape(IShape aShape, int rowPos, int colPos) {
        this.rowList.get(rowPos).putShape(aShape, colPos);
        this.colList.get(colPos).putShape(aShape, rowPos);
    }

    public boolean checkForWinners(IShape aShape) {

        boolean rowHasWinner = this.checkRows(aShape);
        boolean colHasWinner = this.checkColumns(aShape);
        boolean diagHasWinner = this.checkDiagonals(aShape);

        return (rowHasWinner || colHasWinner || diagHasWinner);
    }

    private boolean checkDiagonals(IShape aShape) {
        boolean diag1HasWinner = true;
        boolean diag2HasWinner = true;

        int pos = 0;
        for(int i = 0; i < BOARD_SIZE-1; i++){
            Row aRow = this.rowList.get(i);
            if(!aRow.compareWithShapeInCell(aShape, pos)){
                diag1HasWinner = false;
                break;
            }
            pos++;
        }

        pos = BOARD_SIZE-1;
        for(int i = 0; i < BOARD_SIZE-1; i++){
            Row aRow = this.rowList.get(i);
            if(!aRow.compareWithShapeInCell(aShape, pos)){
                diag2HasWinner = false;
                break;
            }
            pos--;
        }
    
        return (diag1HasWinner || diag2HasWinner);
    }

    private boolean checkRows(IShape aShape) {
        for(Row aRow : this.rowList){
            if(aRow.checkForWinner(aShape))
                return true;
        }
        return false;
    }

    private boolean checkColumns(IShape aShape) {
        for(Column aColumn : this.colList){
            if(aColumn.checkForWinner(aShape)) return true;
        }
        return false;
    }
}
