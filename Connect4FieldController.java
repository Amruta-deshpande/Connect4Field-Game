//package Connect4FieldMVC;
/**
* Connect4FieldController.java

* Version:
*   $1.3$
*   
* Revisions:
*   $1.4$
*   10/05/2015
*/
/**
 * Connect4FieldController class calls methods of view and model. 
 * It is the controller for the MVC implementation of the game.
 * @author Amruta Deshpande
 * @author Shreya Joshi
 *
 */
public class Connect4FieldController {
	public Connect4FieldModel model;
	public Connect4FieldView view;
	public Connect4FieldView view1=new Connect4FieldView ();
	
	char contGamePiece,contGamePiece2;
	String contName,contName2;
	int contCol,contCol2;
	public Connect4FieldController(Connect4FieldModel model,Connect4FieldView view){
	      this.model = model;
	      this.view = view;
	  }
	public Connect4FieldController(){}
	
	
	public void callStuff(){
		model.myMethod();
		int contCh=view1.switchChoice();
		model.startGame(contCh);
		
		
		
	}
	/*
	 * getAgainName() method prompts the user to enter his name from view and passes it to model
	 * @return contName2 Name of the user
	 */
	public String getAgainName() {
		contName2=view1.getName();
		return contName2;
	}
	/*
	 * getAgainCol() method prompts the user to enter the column from view and passes it to model
	 * @return contCol2 column entered by user
	 */
	
	public int getAgainCol() {
		contCol2=view1.nextMove();
		return contCol2;

	}
	/*
	 * getAgainPiece() method prompts the user to enter the column from view and passes it to model
	 * @return name Name of the user
	 */
	public char getAgainPiece() {
		contGamePiece2=view1.getGamePiece();
		return contGamePiece2;

	}
	/*
	 * contPrintBoard() method calls the methods in view to print board
	 * @param char array to print board
	 */
	public void contPrintBoard(char [][]array){
		char [][] contArray= array;
		view1.printBoard(contArray);
		
		
	}
	/*
	 * printDropBoard() method calls the methods in view to print board
	 * @param char array to print board
	 */
	public void printDropPieceBoard(char[][] array) {
		char [][] contArray= array;
		view1.printDropBoard(contArray);
	}
	/*
	 * playWins() method calls the methods in view to display winner
	 * 
	 */
	public void playWins(String name) {
		view1.viewPlaywins(name);
		
	}
	/*
	 * startPlay() method calls method in view to prompt start of game
	 */
	public void startPlay(String name1, char gamePiece) {
		view1.viewStartPlay(name1,gamePiece);
	}
		
		
	
}
