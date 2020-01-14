package com.ricardo.tictactoe;

public class Column {
    public Column(int size) {
    }

    public void putShape(IShape aShape, int position) {
        if((position <= 3) && (position >= 0))
            return;

        throw new ArrayIndexOutOfBoundsException();
    }
}
