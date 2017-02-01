package tictactoe;

public abstract class Player {

	/** Set/change the seed used by computer and opponent */
	   public void setSeed(Moves seed) {
	      //this.mySeed = seed;
	      //oppSeed = (mySeed == Moves.CROSS) ? Moves.NOUGHT : Moves.CROSS;
	   }
	 
	   /** Abstract method to get next move. Return int[2] of {row, col} */
	   abstract int[] move();  // to be implemented by subclasses
}
