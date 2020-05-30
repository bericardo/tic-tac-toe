[![Build Status](https://travis-ci.org/bericardo/tic-tac-toe.svg?branch=master)](https://travis-ci.org/bericardo/tic-tac-toe) [![codecov](https://codecov.io/gh/bericardo/tic-tac-toe/branch/master/graph/badge.svg)](https://codecov.io/gh/bericardo/tic-tac-toe)

# tic-tac-toe

# Usage

Create an object from the Board class, then you can place a shape on the board by using  `putShape(Shape aShape, int rowPos, int colPos)`. After placing a shape, you could see if there is a winner with the `checkForWinners(Shape aShape)` method and use `isFilled()` to know if the board is filled.

We don't need to create a new instance of Cross/Circle everytime we want to put a shape on the board, we just create one instance of each class and that's all we use during the game.

This is a 3 by 3 board so the position of a cell should be (i,j) where i=0,1,2 and j=0,1,2.

# Run Tests
Once you've cloned the project, you should issue the following commands:

```
cd tic-tac-toe/
mvn test
```

# Example

Let's put a cross shape on the top left corner of the board.

``` java
Board board = new Board();
Shape cross = new Cross();

board.putShape(cross, 0, 0);

boolean gameOver = board.checkForWinner(cross); // Checks if cross won.
boolean filled = board.isFilled(); // Checks if the board is completely filled with shapes.
```
