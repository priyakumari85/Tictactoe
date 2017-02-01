package tictactoe;

public abstract class HumanPlayer extends Player {
	
	   
		   /** The player with "theSeed" makes one move, with input validation.
	       Update Cell's content, Board's currentRow and currentCol. */

	   public int[] move(Moves theSeed) {
	      boolean validInput = false;  // for validating input
	      do {
	         if (theSeed == Moves.CROSS) {
	            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
	         } else {
	            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
	         }
	         int row = in.nextInt() - 1;
	         int col = in.nextInt() - 1;
	         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLUMNS
	               && board.cells[row][col].content == Moves.EMPTY) {
	            board.cells[row][col].content = theSeed;
	            board.currentRow = row;
	            board.currentCol = col;
	            validInput = true; // input okay, exit loop
	         } else {
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not valid. Try again...");
	         }
	      } while (!validInput);   // repeat until input is valid
	   }

}
