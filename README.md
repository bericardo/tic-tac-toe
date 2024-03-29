[![Build Status](https://travis-ci.org/bericardo/tic-tac-toe.svg?branch=master)](https://travis-ci.org/bericardo/tic-tac-toe) [![codecov](https://codecov.io/gh/bericardo/tic-tac-toe/branch/master/graph/badge.svg)](https://codecov.io/gh/bericardo/tic-tac-toe)

# tic-tac-toe

# Usage

Create an instance of the Board class and use  `putShape(Shape aShape, int rowPos, int colPos)` to place a Cross or Circle shape on the board. Use `checkForWinners(Shape aShape)` after placing a shape on the board to check if the game is over, this method returns true if any column, row or diagonal has shapes equal to `aShape` in every cell. When every position of the board is taken by a shape, `isFilled()` returns true. Also, you can check if the shape was placed on the board with `placedOnBoard()`.

Every time you want to place a shape on the board, you need to create a new instance of that shape class, you cannot re-use the same object. The default size of the board is 3x3 and a valid position is (row,column) where row = 0,1,2 and column=0,1,2.

# Run Tests
Once you've cloned the project, in order to run the tests, you should go to the `tic-tac-toe/` folder and issue the following command:

```
mvn test
```

# Example

The following snippet shows an example of how to place a Cross shape on the top left corner of the board.

``` java
Board board = new Board();
Shape cross = new Cross();

board.putShape(cross, 0, 0);

boolean placedOnBoard = cross.placedOnBoard();
boolean crossShapeHasWon = board.checkForWinner(cross);
boolean boardCompletelyFilled = board.isFilled();
```
