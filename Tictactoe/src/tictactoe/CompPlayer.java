package tictactoe;

	/**
	 * Abstract superclass for all AI players with different strategies.
	 * To construct an AI player:
	 * 1. Construct an instance (of its subclass) with the game Board
	 * 2. Call setSeed() to set the computer's seed
	 * 3. Call move() which returns the next move in an int[2] array of {row, col}.
	 *
	 * The implementation subclasses need to override abstract method move().
	 * They shall not modify Cell[][], i.e., no side effect expected.
	 * Assume that next move is available, i.e., not game-over yet.
	 */
public abstract class CompPlayer extends Player{
	  // protected int ROWS = GameInit.ROWS;  // number of rows
	  // protected int COLS = GameInit.COLS;  // number of columns
	 
	   protected int ROWS = Board.ROWS;  // number of rows
	   protected int COLS = Board.COLUMNS;  // number of columns
	
	   protected Cell[][] cells; // the board's ROWS-by-COLS array of Cells
	   protected Moves mySeed;    // computer's seed
	   protected Moves oppSeed;   // opponent's seed
	 
	   /** Constructor with reference to game board */
	   public CompPlayer(Board board) {
	      cells = board.cells;
	   }
	 
	   /** Set/change the seed used by computer and opponent */
	   public void setMove(Moves seed) {
	      this.mySeed = seed;
	      oppSeed = (mySeed == Moves.CROSS) ? Moves.NOUGHT : Moves.CROSS;
	   }
	 
	   /** Abstract method to get next move. Return int[2] of {row, col} */
	   abstract int[] move();  // to be implemented by subclasses
}

