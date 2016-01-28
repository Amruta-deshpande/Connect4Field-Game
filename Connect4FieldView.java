//package Connect4FieldMVC;
/**
* Connect4FieldView.java

* Version:
*   $1.3$
*   
* Revisions:
*   $1.4$
*   10/05/2015
*/
import java.util.Scanner;

/**
 * Connect4FieldView class takes the input from the user and displays the result via the controller. 
 * It is the view for the MVC implementation of the game.
 * @author Amruta Deshpande
 * @author Shreya Joshi
 *
 */

public class Connect4FieldView {
	char gamePiecechar;
	String nameOfPlayer;
	
	/*
	 * getGamePiece() method prompts the user to select the gamepiece of his choice
	 * @return gamePieceChar selected gamePiece by the user
	 */
	public char getGamePiece() {
		Scanner inppiece = new Scanner(System.in);
    	System.out.println("Enter the game piece for the game(+/*):");
    	gamePiecechar = inppiece.next().charAt(0);
		return gamePiecechar;
	}
	/*
	 * getName() method prompts the user to enter his name
	 * @return name Name of the user
	 */
	
	public String getName() {
		String name = null;
		Scanner inpname = new Scanner(System.in);
    	System.out.println("Enter the name of the Player:");
    	name = inpname.next();
    	return name;
	}

	/*
	 * nextMove() method prompts the user to enter the column to drop the Gamepiece
	 * @return columnnum column to drop the piece
	 */
	public int nextMove() {
		int columnnum=0;
		Scanner inpnum = new Scanner(System.in);
    	System.out.println("Enter the column number to insert piece");
    	columnnum = inpnum.nextInt();
		return columnnum;
	}
	
	/*
	 * printBoard() method prints the array initialized in the model
	 * @param array[][] field of hangman
	 */

	public void printBoard(char [][]array) {
		
		 System.out.println("The initial board is");
		 for(int iterator=0;iterator<9;iterator++){
			  	System.out.println(array[iterator]);
		    	}
	}
	/*
	 * printDropBoard() method prints the array of DropPiece method in the model
	 * @param array[][] field of hangman
	 */
	
	public void printDropBoard(char [][]array){
		for(int iterator = 0; iterator <9; iterator ++){
		    for(int jiterator  = 0; jiterator <26; jiterator ++){
		    		
	    			System.out.print(array[iterator ][jiterator ]);
	    				    		
		    	}
		    System.out.println();
		    } 
		   
		}

	/*
	 *  viewPlaywins() method prints the name and result of the winner
	 *  @param name String name of winner
	 */
	public void viewPlaywins(String name) {
			System.out.println("CONGRATULATIONS!!! ");
			System.out.println("PLAYER "+name+" WINS");
	}

	/*
	 *  viewStartPlay() method prints the name and gamePiece of player
	 *  @param name1 String name of player
	 *  @param gamePiece Player's gamePiece
	 *  
	 */
	public void viewStartPlay(String name1, char gamePiece) {
		System.out.println("Player "+name1+" start playing with game piece "+gamePiece);
		
	}

	/*
	 * switchChoice() method prompts user for the choice of game
	 * @return choice integer value for choosing
	 */
	public int switchChoice() {
		System.out.println("\nSelect the type of game to be played\n\n1.Single Player\n\n2.Two Players");
		Scanner inp= new Scanner(System.in);
		int choice=Integer.parseInt(inp.next());
		return choice;
		
	}
}

