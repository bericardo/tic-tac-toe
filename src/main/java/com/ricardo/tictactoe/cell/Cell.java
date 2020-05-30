package com.ricardo.tictactoe.cell;

import com.ricardo.tictactoe.shape.Shape;

public class Cell {
    private Shape shape;
    private ICellState state;

    public Cell() {
        this.state = new CellFree();
    }

    /**
     * Store aShape on the current cell if its state is CellFree and change its state
     * to CellTaken. If this cell has already a shape stored (its state is CellTaken),
     * aShape it is not stored.
     *
     * @param aShape    shape to be stored on the current cell
     */
    public void putShape(Shape aShape) {
        this.shape = this.state.putShape(aShape, this.shape);
        this.state = new CellTaken();
    }

    /**
     * Compares aShape with the shape stored on this cell
     *
     * @param aShape    shape to be compared with the shape stored on the current cell
     * @return          true if the shape stored on the current cell is equal to aShape
     */
    public boolean compare(Shape aShape) {
        if (aShape == null) throw new InvalidShapeException();
        return this.state.compare(aShape, this.shape);
    }
}