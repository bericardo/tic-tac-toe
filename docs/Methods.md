# Class Board

| Method | Description |
| --- | --- |
| `public void putShape(IShape aShape,int rowPos,int colPos)` | Returns nothing. Puts an *IShape* on the board where *rowPos* (Row Position) and *colPos* (Column Position) is the position of the cell. |
| `public boolean checkForWinners(aShape : IShape)` | Returns *true* if a Row, Column or Diagonal have the same shape in all of its cells. |
| `public boolean isFilled()` | Returns *true* if the board it filled completely. |

# Class Column

| Method | Description |
| --- | --- |
| `public boolean putShape(IShape aShape, int cellPos)` | Returns *true* if the shape was placed. Puts an *IShape* in a cell of the Column where *cellPos* is the position of the cell. |
| `public boolean checkForWinner(IShape aShape)` | Returns *true* if all of the shapes stored in its cells are equal to *aShape*, *false* if any of them is different or if the cell is empty. |

# Class Row

| Method | Description |
| --- | --- |
| `public boolean putShape(IShape aShape, int cellPos)` | Returns *true* if the shape was placed. Puts an *IShape* in a cell of the Row where *cellPos* is the position of the cell. |
| `public boolean checkForWinner(IShape aShape)` | Returns *true* if all of the shapes stored in its cells are equal to *aShape*, *false* if any of them is different or if the cell is empty. |

# Class Cell

| Method | Description |
| --- | --- |
| `public boolean forTest_isFree()` | Returns *true* if the cell is empty, *false* if is not. |
| `public boolean putShape(IShape aShape)` | Returns *true* if the shape was placed. Puts *aShape* in the cell. |
| `public boolean compare(IShape aShape)` | Returns *true* if the shape stored in the cell is equal to *aShape*. If the shape is different or the cell is empty( *CellFree* ), it returns *false*. |

# Exceptions

| Exception | Description |
| --- | --- |
| `InvalidPositionException` | It is used in the *Board* class. This is thrown if the position of the cell, which is specified by passing two integers ( *rowPos* and *colPos* ), is out range. A position is not valid if any of the two integers is  negative or greater than the board size. |
| `InvalidShapeException` | It is used in the *Cell* class. This is thrown if we try to put a **Null** on the board instead of an *IShape*. |

