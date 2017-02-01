package tictactoe;

public class HasWon {
	   /** Return true if the player with "theSeed" has won after placing at
    (currentRow, currentCol) */
	Cell[][] cells;
	public boolean hasWon(Board board, int currentRow, int currentCol,Moves move) {
       return (cells[currentRow][0].content == move         // 3-in-the-row
                && cells[currentRow][1].content == move
                && cells[currentRow][2].content == move
           || cells[0][currentCol].content == move      // 3-in-the-column
                && cells[1][currentCol].content == move
                && cells[2][currentCol].content == move
           || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].content == move
                && cells[1][1].content == move
                && cells[2][2].content == move
           || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].content == move
                && cells[1][1].content == move
                && cells[2][0].content == move);
	}

}
