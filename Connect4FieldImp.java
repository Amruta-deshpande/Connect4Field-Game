//package Connect4FieldMVC;
/**
* Connect4FieldImp.java

* Version:
*   $1.3$
*   
* Revisions:
*   $1.4$
*   10/05/2015
*/
/**
 * Connect4FieldImp class calls methods of controller. 
 * It is the implementation class  for the MVC implementation of the game.
 * @author Amruta Deshpande
 * @author Shreya Joshi
 *
 */


public class Connect4FieldImp {
	public static void main(String arg[]){
		Connect4FieldModel model=new Connect4FieldModel();
		Connect4FieldView view=new Connect4FieldView();
		Connect4FieldController controller=new Connect4FieldController(model,view);
		controller.callStuff();
	}
}//Connect4FieldImp.java
