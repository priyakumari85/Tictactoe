package tictactoe;

import java.util.Scanner;
/**
 * The main class for the Tic-Tac-Toe (Console-OO, non-graphics version)
 * It acts as the overall controller of the game.
 */
public class GameInit {
   private Board board;            // the game board
   private GameState currentState; // the current state of the game (of enum GameState)
   private Moves currentPlayer;     // the current player (of enum Moves)
   private DiffLevel difficultyLevel; // sets player difficulty (of enum)
   
   private HasWon haswon; 
   private HumanPlayer hplayer;
   private CompPlayerDiff1 cPlayerDiff1; 
   private CompPlayerDiff2 cPlayerDiff2; 
   private CompPlayerDiff3 cPlayerDiff3; 
   
   private static Scanner in = new Scanner(System.in);  // input Scanner
 
   /** Constructor to setup the game */
   public GameInit(int boardSize) {
      board = new Board(boardSize);  // allocate game-board
 
      // Initialize the game-board and current status
      initGame();
      // Play the game once. Players CROSS and NOUGHT move alternately.
      do {
         playerMove(currentPlayer); // update the content, currentRow and currentCol
         board.paint();             // ask the board to paint itself
         updateGame(currentPlayer); // update currentState
         // Print message if game-over
         if (currentState == GameState.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == GameState.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == GameState.DRAW) {
            System.out.println("It's Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == Moves.CROSS) ? Moves.NOUGHT : Moves.CROSS;
      } while (currentState == GameState.PLAYING);  // repeat until game-over
   }
 
   /** Initialize the game-board contents and the current states */
   public void initGame() {
      board.init();  // clear the board contents
      currentPlayer = Moves.CROSS;       // CROSS plays first
      currentState = GameState.PLAYING; // ready to play
   }
 
 
   /** Update the currentState after the player with "theSeed" has moved */
   public void updateGame(Moves theSeed) {
      if (haswon.hasWon(board,board.currentRow ,board.currentCol,theSeed)) {  // check for win
         currentState = (theSeed == Moves.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } else if (board.isDraw()) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
	  System.out.print("Enter number to declare board Size :");
	  int bSize = Integer.parseInt(System.console().readLine());
      new GameInit(bSize);  // Let the constructor do the job
   }
}
