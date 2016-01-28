/**
 * Connect4FieldModel.java

 * Version:
 *   $1.3$
 *   
 * Revisions:
 *   $1.4$
 *   10/05/2015
 */
//package Connect4FieldMVC;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
/**
 * Connect4FieldModel class implements the Interface Connect4FieldInterface which has methods defined for
 * the game Hangman. It checks the winning conditions and losing conditions.
 * It is the model for the MVC implementation of the game.
 * @author Amruta Deshpande
 * @author Shreya Joshi
 *
 */

class Connect4FieldModel implements Connect4FieldInterface {
	
	static char[][] array = new char[9][26];		//array for field
	boolean flag1;
	char gamePiece;
	int count;
	int column;
	boolean flag;
	String name1,name2;
	int row=9;
	int columnCount=0;
	int countercolumn=0;
	int col;
	int counterrow=0;
	int counterEastDiagonal=0;
	int counterWestDiagonal=0;
	int rowtoinsert;
	int coltoinsert;
	int lastColumnCount;
	int lastRow;
	int rowNumber;
	int lastColumn;
	int lastRowCount;
	int lastEastDiagonalCount;
	int lastWestDiagonalCount;
	int rowCount;
	
	int totalLeftColumnCount=0;
	int totalRightColumnCount=0;
	int totalUpRowCount=0;
	int totalDownRowCount=0;
	int totalUpEastDiagonalCount=0;
	int totalDownEastDiagonalCount=0;
	int totalEastDiagonalCount=0;
	int totalUpWestDiagonalCount=0;
	int totalDownWestDiagonalCount=0;
	int totalWestDiagonalCount=0;
	
	Connect4FieldController controller=new Connect4FieldController();	//controller object to call its methods
	
	Connect4FieldModel(char[][] array){
		for(int iiterator = 0; iiterator<9; iiterator++){
		    for(int jiterator = 0; jiterator<26; jiterator++){
		    	
		    	 	array[iiterator][jiterator] =' ';
			        //System.out.print(array[iiterator][jiterator]);
		     }	
		  }

		int kiterator,temp=26;
		for(int iterator=0;iterator<9;iterator++){
		 temp--;
		 for(kiterator=iterator;kiterator<temp;kiterator++)
		    		{			
		    			
			 			array[iterator][kiterator]='O';
		    			
		    		}
		    		temp=kiterator;
		   }		
		
		   
		    	
	}
	
	Connect4FieldModel(){
		
	}
	
	
/*
 * myMethod initializes the array by calling the constructor also calls the init() method
 */
 public  void myMethod(){
	  
	   Connect4FieldModel cn=new Connect4FieldModel(array);
	   controller.contPrintBoard(array);
	  
	  
 }
 /**
	 * checkIfPieceCanBeDroppedIn takes the column value and checks if the gamePiece can be inserted
	 * @return: Boolean value returned sets the flag
	 * @param: column to insert the gamepiece
	 * @param rowNumber to insert the piece at row
	 * @param flag1 to set the boolean
	 */

public boolean checkIfPiecedCanBeDroppedIn(int column) {
	
	col=column;
	int row=9;
	
	if(col<0) return false;
	  for(int iterator=row-1;iterator>=0;iterator--){
	      if(array[iterator][col]=='O'){
	    	  
		   rowNumber=iterator;
		   flag1=true;
		   break;
		  
	      }
	   else{
		
	    flag1=false;	
	   }
   }
	  if(flag1==true){
		return true;
	  }
	  else
		return false;
	
}
/**
 * dropPieces takes the column value and the gamePiece and inserts the gamePiece
 * @return: Boolean value returned sets the flag
 * @param: column to insert the gamepiece
 * @param: gamePiece to be dropped
 * 
 */

public void dropPieces(int column, char gamePiece) {
	 int col=column;
   
	 	int classcol=26;
	 	if(flag==true){
    		array[rowNumber][col]=gamePiece;
    		controller.printDropPieceBoard(array);
	 	}
	 	
	 		
		
}

/**
 *	didLastMoveWin  checks conditions whether the dropped piece completes the winning condition
 * @return: Boolean value returned sets the flag
 * @param totalLeftColumnCount to store horizontal counter value
 * @param totalRightColumnCount to store horizontal counter value
 * @param totalUpRowCount to store up counter value
 * @param totalDownRowCount to store down counter value
 * @param TotaleastDiagonalCount to store diagonal value
 * @param TotalWestDiagonalCount to store diagonal value
 */
public boolean didLastMoveWin() {
	

  totalLeftColumnCount=checkLeftSideOfRow();
  totalRightColumnCount=chkRightSideOfRow();
  columnCount=totalLeftColumnCount+totalRightColumnCount+1;
  totalUpRowCount=checkUptSideOfColumn();
  totalDownRowCount=chkDownSideofColumn();
  rowCount=totalUpRowCount+totalDownRowCount+1;
  totalUpEastDiagonalCount=checkUpEastSideOfDiagonal();
  totalDownEastDiagonalCount=checkDownEastSideOfDiagonal();
  totalEastDiagonalCount=totalUpEastDiagonalCount+totalDownEastDiagonalCount+1;
  totalUpWestDiagonalCount=checkUpWestSideOfDiagonal();
  totalDownWestDiagonalCount=checkDownWestSideOfDiagonal();
  totalWestDiagonalCount=totalUpWestDiagonalCount+totalDownWestDiagonalCount+1;
	    
	    if(columnCount>=4){
	    	//controller.playWins();
	    	//System.out.println("Game piece match Horizantally");
	    	return true;
	    }
	    
	    else if(rowCount>=4){
	    	//System.out.println("Game piece match Vertically");
	    	return true;
	    }

	    else if(totalEastDiagonalCount>=4){
	    	//System.out.println("Game piece match East Diagonally");
	    	return true;
        }
	    else if(totalWestDiagonalCount>=4){
	    	//System.out.println("Game piece match West Diagonally");
	    	return true;
        }
	    else{	
	    	return false;
	    }
   
}
//Method is written for checking 4 consecutive pieces to the left	
public int checkLeftSideOfRow(){
			countercolumn=0;
           int rowleft=rowNumber;
           int columnleft=col;
       
          for (columnleft = col; columnleft > 0; columnleft--) {
              
       	   char left=array[rowleft][columnleft] ;
       	   char leftminusone=array[rowleft][columnleft-1] ;
       	   
                  if (array[rowleft][columnleft] != 'O' && left==leftminusone && array[rowleft][columnleft] != ' '){
                       countercolumn=countercolumn+1;
                   
                  }
                  else{
               	   break;
                  }
             
          }   
            
            return countercolumn;
          
	}
//Method is written for checking 4 consecutive pieces to the right	

public int chkRightSideOfRow(){
		countercolumn=0;
       int rowright=rowNumber;
       int columnright=col;
       for ( columnright = col; columnright < 26 ; columnright++) {
              if( array[rowright][columnright] == array[rowright][columnright+1] && array[rowright][columnright] != 'O' && array[rowright][columnright] != ' ' )
              {
           	  
           	   ++countercolumn;
              }  
              else{
           	   break;
              }
          
       }
       
       return countercolumn;
}
	
//Method is written for checking 4 consecutive pieces above each other	
public int checkUptSideOfColumn(){
		counterrow=0;
           int rowup=rowNumber;
           int columnup=col;
       
           for (rowup = rowNumber; rowup > 0; rowup--) {
        	   char up=array[rowup][columnup] ;
        	   char upminusone=array[rowup][columnup-1] ;
       	 
                  if (array[rowup][columnup] != 'O' && up==upminusone && array[rowup][columnup] != ' '){
               		
                       counterrow=counterrow+1;
                   
                  }
                  else{
   	        	   break;
   	           } 
          }  
          
            return counterrow;
          
	}
//Method is written for checking 4 consecutive pieces below each other
public int chkDownSideofColumn(){
		counterrow=0;
       int rowdown=rowNumber;
       int columdown=col;
       
       for (  rowdown=rowNumber; rowdown >0; rowdown++) {
       	if(rowdown==8){
           	break;
           }
           else if( array[rowdown][columdown] == array[rowdown+1][columdown] && array[rowdown][columdown] != 'O' && array[rowdown][columdown] != ' ' )
           {
           	   ++counterrow;
           }  
           
            
       	  else{
	        	   break;
	              } 
       }
      
       return counterrow;
}

//Method is written for checking 4 consecutive pieces above diagonally
	public int checkUpEastSideOfDiagonal(){
	 counterEastDiagonal = 0;
           int roweastup=rowNumber;
           int columneastup=col;
    
       	   while(roweastup > 0 && columneastup < 26){
       	   char up=array[roweastup][columneastup] ;
       	   char upminusone=array[roweastup-1][columneastup+1] ;
       	  
                  if (array[roweastup][columneastup] != 'O' && up==upminusone && array[roweastup][columneastup] != ' '){
               	
               		counterEastDiagonal=counterEastDiagonal+1;
                   
                  }
                  else{
               	   break;
                  }
                  roweastup--;
                  columneastup++;
	}
   
            return counterEastDiagonal;
	}
	//Method is written for checking 4 consecutive pieces below diagonally
	public int checkDownEastSideOfDiagonal(){
			counterEastDiagonal=0;
           int rowEastDown=rowNumber;
           int columnEastDown=col;

          while(rowEastDown < 8 && columnEastDown > 0){
       	     char up=array[rowEastDown][columnEastDown] ;
       	     char upminusone=array[rowEastDown+1][columnEastDown-1] ;
       	 
                   if (array[rowEastDown][columnEastDown] != 'O' && up==upminusone && array[rowEastDown][columnEastDown] != ' ')
                   {
               		counterEastDiagonal=counterEastDiagonal+1;
                       
                   }
                   else{
                   	break;
                   }
                   rowEastDown++;
                   columnEastDown--;
                 }
  
            return counterEastDiagonal;
          
}
	
	//Method is written for checking 4 consecutive pieces above diagonally
	public int checkUpWestSideOfDiagonal(){
		 counterWestDiagonal = 0;
	            int rowWestUp=rowNumber;
	            int columnWestUp=col;
	         
	        	   while(rowWestUp > 0 && columnWestUp < 26 ){
	        	   char up=array[rowWestUp][columnWestUp] ;
	        	   char upminusone=array[rowWestUp-1][columnWestUp-1] ;
	        	  
	                   if (array[rowWestUp][columnWestUp] != 'O' && up==upminusone && array[rowWestUp][columnWestUp] != ' '){
	                	
	                		counterWestDiagonal=counterWestDiagonal+1;
	                   }

	                   else{
	                	   break;
	                   }
	                 rowWestUp--;
	                 columnWestUp--;
		}
	             return counterWestDiagonal;
	           
		}
	//Method is written for checking 4 consecutive pieces below diagonally	
	public int checkDownWestSideOfDiagonal(){
			counterWestDiagonal=0;
	            int rowWestDown=rowNumber;
	            int columnWestDown=col;

	                 while(rowWestDown < 8 && columnWestDown > 0){
	        	     char up=array[rowWestDown][columnWestDown] ;
	        	     char upminusone=array[rowWestDown+1][columnWestDown+1] ;
	        	 
	                    if (array[rowWestDown][columnWestDown] != 'O' && up==upminusone && array[rowWestDown][columnWestDown] != ' ')
	                    {
	                		counterWestDiagonal=counterWestDiagonal+1;
	                        
	                    }
	                    else{
	                    	break;
	                    }
	                    rowWestDown++;
		                columnWestDown++;
	                  }
	             
	                return counterWestDiagonal;
	        
}
	/*
	 * 			checks the draw conditions	
	 */

public boolean isItaDraw() {
	boolean bool= false;
	int count=0;
	   for(int coll=0; coll<26;coll++) {  
		   if(array[0][coll]!='O'){
			count=count+1;
		   }
	   }
	   if(count==25){
		   bool=true;
	   }
	   if(bool==true){
		   return true;
		}
	   else return false;

}

/*
* calls the startGame() method
*  */
public void init(PlayerInterface playerA,PlayerInterface playerB) {
	
	startGame(1);
}
public void startGame(int contCh) {
	
	int choice;
	choice=contCh;
	
    switch(choice) {
    case 1:
    {
    	if(count==0){
    		/*
    		 * methods for prompting user in the view are called via controller
    		 */
    		name1=controller.getAgainName();
    		gamePiece = controller.getAgainPiece();
		}
		
	   do{
		   if(gamePiece =='*')
				gamePiece ='+';
		   
		  controller.startPlay(name1,gamePiece); 	
		//System.out.println("Player "+name1+" start playing with game piece "+gamePiece);
		column=controller.getAgainCol();
		
		flag=checkIfPiecedCanBeDroppedIn(column);
		
		dropPieces(column,gamePiece);
		if(didLastMoveWin()){
			  // System.out.println("Player "+name1+" wins");
			controller.playWins(name1);
			   break;
		   }
		if(gamePiece =='+')
			gamePiece ='*';
		
		playTheGame();
		
		if(didLastMoveWin()){
			controller.playWins("Computer");
			   break;
		      }
		
	     }while(!isItaDraw());
	   
	break;
    
}
   
    case 2:
    {
	if(count==0){
		/*
		 * methods for prompting user in the view are called via controller
		 */
		name1=controller.getAgainName();
		gamePiece = controller.getAgainPiece();
		name2=controller.getAgainName();
	}
	
   do{
	   if(gamePiece =='*')
			gamePiece='+';
		
	controller.startPlay(name1,gamePiece);	
	//System.out.println("Player "+name1+" start playing with game piece"+gamePiece);
	//column=playerA.nextMove();
	column=controller.getAgainCol();
	
	//System.out.println("Column from cont is"+column);
	
	
	flag=checkIfPiecedCanBeDroppedIn(column);
	dropPieces(column,gamePiece);
	
	if(didLastMoveWin()){
		   //System.out.println("Player "+name1+" wins");
		controller.playWins(name1);
		   break;
	   }
	if(gamePiece =='+')
		gamePiece ='*';
	controller.startPlay(name2,gamePiece);
	//System.out.println("Player "+name2+" start playing with game piece  "+gamePiece);
	
	
	//column=playerB.nextMove();
	column=controller.getAgainCol();
	
	flag=checkIfPiecedCanBeDroppedIn(column);
	
	dropPieces(column,gamePiece);
	
	if(didLastMoveWin()){
		   //System.out.println("Player "+name2+" wins");
		controller.playWins(name2);   
		break;
	   }
   }while(!isItaDraw());
  }

   }	
}

/*
 * playtheGame method is written for the computer Player for wining and defensive strategies
 */
public void playTheGame() {
	int insertToRow=0;
	int insertToColumn=0;
	//int compRowInsert;
	//int compColInsert;

	if(columnCount==3){
			if(totalLeftColumnCount==2 && array[rowNumber][column+1]!='O'){
				insertToRow=rowNumber;
				 insertToColumn=column+1;
				 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
				 dropPieces(insertToColumn,gamePiece);					
			}
			if(totalRightColumnCount==2 && array[rowNumber][column-1]!='O'){
				insertToRow=rowNumber;
				 insertToColumn=column-1;
				 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
				 dropPieces(insertToColumn,gamePiece);					
			}
			
			else computerPlayer();
			
	}
			
	else if(rowCount==3){
		if(totalDownRowCount==2){
			insertToRow=rowNumber-1;
			 insertToColumn=column;
			 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
			 dropPieces(insertToColumn,gamePiece);					
		}
		else computerPlayer();
	}
	
	
	else if(totalEastDiagonalCount==3){
		if(totalUpEastDiagonalCount==2){
			insertToRow=rowNumber-1;
			 insertToColumn=column-1;
			 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
			 dropPieces(insertToColumn,gamePiece);	
			
		}
		if(totalDownEastDiagonalCount==2)
		{
			insertToRow=rowNumber+1;
			 insertToColumn=column+1;
			 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
			 dropPieces(insertToColumn,gamePiece);	
		}
		else computerPlayer();
		
	}
	
	else if(totalWestDiagonalCount==3){
		if(totalUpWestDiagonalCount==2){
			
			insertToRow=rowNumber-1;
			 insertToColumn=column+1;
			 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
			 dropPieces(insertToColumn,gamePiece);	
			
		}
		if(totalDownWestDiagonalCount==2)
		{
			insertToRow=rowNumber+1;
			 insertToColumn=column-1;
			 flag=checkIfPiecedCanBeDroppedIn(insertToColumn);
			 dropPieces(insertToColumn,gamePiece);	
			
		}
		else computerPlayer();
	}
    else computerPlayer();

}
		
/*
 * computerPlayer mwthod defines the moves of the computer		
 */
void computerPlayer(){
	
	ArrayList<int []> arrayIndices= new ArrayList<int []>();
	Random rn=new Random();
	
	if(column>8 && column<16){
	int left[]=new int[2];
	left[0]=rowNumber;
	left[1]=column-1;
	arrayIndices.add(left);
	
	int right[]=new int[2];
	right[0]=rowNumber;
	right[1]=column+1;
	arrayIndices.add(right);
	
	int randarray[]=arrayIndices.get(rn.nextInt(arrayIndices.size()));
	
	
	rowtoinsert=randarray[0];
	coltoinsert=randarray[1];
	
	flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
	dropPieces(coltoinsert,gamePiece);
	}
	
	else if(column==8){
		int right[]=new int[2];
		right[0]=rowNumber;
		right[1]=column+1;
		rowtoinsert=right[0];
		coltoinsert=right[1];
		
		
		flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
		dropPieces(coltoinsert,gamePiece);
		
	}
	else if(column==16){
		int left[]=new int[2];
		left[0]=rowNumber;
		left[1]=column-1;
		
		int rowtoinsert=left[0];
		int coltoinsert=left[1];
		
		
		flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
		dropPieces(coltoinsert,gamePiece);
		
		
	}
	else if(column<8 && column>=0){
		
		int right[]=new int[2];
		right[0]=rowNumber;
		right[1]=column+1;
		
		rowtoinsert=right[0];
		coltoinsert=right[1];
		
		
		flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
		dropPieces(coltoinsert,gamePiece);
		}
	else if(column>16 && column<24){
		int left[]=new int[2];
		left[0]=rowNumber;
		left[1]=column-1;
		arrayIndices.add(left);
		
		int right[]=new int[2];
		right[0]=rowNumber+1;
		right[1]=column;
		arrayIndices.add(right);
		
		int randarray[]=arrayIndices.get(rn.nextInt(arrayIndices.size()));
		
		
		int rowtoinsert=randarray[0];
		int coltoinsert=randarray[1];
		
		flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
		dropPieces(coltoinsert,gamePiece);
		}
	
	if(column==24){
		ArrayList<Integer> some=new ArrayList<Integer>();
		some.add(7);
		some.add(3);
		some.add(10);
		some.add(19);
		some.add(21);
		int coltoinsert= some.get(rn.nextInt(some.size()));
		flag=checkIfPiecedCanBeDroppedIn(coltoinsert);
		dropPieces(coltoinsert,gamePiece);
		
	}

}
}//endOfClass Connect4FieldModel.java
