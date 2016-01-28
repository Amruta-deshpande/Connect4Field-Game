//package Connect4FieldMVC;

import java.util.Scanner;

class Player implements PlayerInterface{
	char gamePiecechar;
	String nameOfPlayer;
	Connect4FieldModel aConnect4Field = new Connect4FieldModel();
	Player(Connect4FieldInterface theField, String name, char gamePiece){
		aConnect4Field=(Connect4FieldModel) theField;
		nameOfPlayer=name;
		gamePiecechar=gamePiece;
		
	}
	
	public static void main(String args[]){
		
	}

	@Override
	public char getGamePiece() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextMove() {
		// TODO Auto-generated method stub
		return 0;
	}
   
	
	
	
}
