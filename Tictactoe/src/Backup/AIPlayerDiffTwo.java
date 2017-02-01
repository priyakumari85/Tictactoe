package tictactoe;
/**
 * Computer move based on simple table lookup of preferences
 */

public class AIPlayerDiffTwo extends AIPlayer {

	  private HasWon haswon; 
	   /** Search for the first empty cell, according to the preferences
	    *  Assume that next move is available, i.e., not gameover
	    *  @return int[2] of {row, col}
	    */
	   @Override
	   public int[] move() {
	      for (int[] move : preferredMoves) {
	         if (cells[move[0]][move[1]].content == Moves.EMPTY) {
	            return move;
	         }
	      }
	      assert false : "No empty cell?!";
	      return null;
	   }
	}

