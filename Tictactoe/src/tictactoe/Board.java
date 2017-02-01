package tictactoe;

/**
 * The Board class models the game-board.
 */
public class Board {  // save as Board.java
   // Named-constants for the dimensions
   public static int ROWS = 0;
   public static int COLUMNS = 0;
 
   // package access
   Cell[][] cells;  // a board composes of ROWS-by-COLS Cell instances
   int currentRow, currentCol;  // the current seed's row and column
 
   /** Constructor to initialize the game board */
   public Board(int boardSize) {
	   ROWS = boardSize;
	   COLUMNS = boardSize;
      cells = new Cell[ROWS][COLUMNS];  // allocate the array
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            cells[row][col] = new Cell(row, col); // allocate element of the array
         }
      }
   }
 
   /** Initialize (or re-initialize) the contents of the game board */
   public void init() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            cells[row][col].clear();  // clear the cell content
         }
      }
   }
 
   /** Return true if it is a draw (i.e., no more EMPTY cell) */
   public boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            if (cells[row][col].content == Moves.EMPTY) {
               return false; // an empty seed found, not a draw, exit
            }
         }
      }
      return true; // no empty cell, it's a draw
   }
 

 
   /** Paint itself */
   public void paint() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            cells[row][col].paint();   // each cell paints itself
            if (col < COLUMNS - 1) System.out.print("|");
         }
         System.out.println();
         if (row < ROWS - 1) {
            System.out.println("-----------");
         }
      }
   }
}