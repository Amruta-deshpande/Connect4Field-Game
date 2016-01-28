//package CalculatorMVC;
/**
 * CalculatorController.java


 * 
 * Version:
 *   $1.1$
 *   
 * Revisions:
 *   $10/05/2015 9.00$
 */
/**
 * CalculatorController class calls the view and model methods
 * 
 * @author Amruta Deshpande
 * @author Shreya Joshi
 */
public class CalculatorController {
	public CalculatorModel model;
	public CalculatorView view;
	String contString;
	/*
	 * constructor initializes model and view 
	 */
	public CalculatorController(CalculatorModel model,CalculatorView view){
	      this.model = model;
	      this.view = view;
	  }
	
	/*
	 * callStuff method passes the string given by user to model for evaluation
	 * also it prints the result
	 */
	public void callStuff(){
		contString=view.getExpression();
		double resCont=model.calculator(contString);
		view.printResult(resCont);
	}
}
