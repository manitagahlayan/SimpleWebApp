package itu.oops.lab;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a TicTacToe Game and players 
 * will take turn to make their move. 
 * Player will win of row, col or dia match with their moves.
 *
 */
public class TicTacToe{
	
	//board game of 3X3
	private char[][] board;
	//player 'X' or 'O'
	private char player; 
	
	/**
	 * Class constructor
	 * Instantiate board to be a 3 by 3 char array of spaces.
	 * Set player to be 'X'.
	 */
	public TicTacToe() {
		/*
		* creating an empty board, with an initial value
		* of a space (' ')
		*/
		this.board = new char[3][3];
		for(int i = 0; i < 3; i++){
			for (int j=0; j < 3; j++){
				board[i][j] = ' ';
			}
		}
		//initialize the player to X
		this.player = 'X';
	}
	
	
	/**
	 * @param move Input by the player
	 * @return true or false if that move is added to the board
	 * This will add the current player's symbol to the board depending on the move 
	 */
	public boolean play(String move) {
		
		boolean validPlay = false;
		//converting move by player to UpperCase
		String input = move.toUpperCase();
		//get the value of row from input
		char c = input.charAt(0);
		int row=0;
		//Since rows are'A/B/C' format, initializing rows to 0/1/2
		switch (c) {
		case 'A':
			row =0;
			break;
		case 'B':
			row = 1;
			break;
		case 'C':
			row = 2;
			break;
		default:
			break;
		}
		//get the value of column from input
		String col= input.substring(1);
		int column = Integer.parseInt(col)-1;
		//if this row and column are not occupied already, make the move on the board
		if(board[row][column] == ' '){
			board[row][column]= player;
			print(input);
			validPlay = true;
		}else{
			System.out.println("This move has already been made. Please make another move.");
			validPlay = false;
		}
		
		return validPlay; 
	}
	
	
	/**
	 * Switches the current player from X to O, or O to X.
	 */
	public void switchTurn() {
		// toggle between 'X' and 'O'
		char player = getPlayer();
		if(player =='X'){
			this.player ='O';
		}else{
			this.player ='X';
		}
	}
	
	
	/**
	 * @return boolean Returns true or false 
	 * This method will return true if the current player wins the game.
	 * Three in a row, column or either diagonal.
	 * Otherwise, return false.
	 */
	public boolean won() {
		
		boolean gameWon = false;
		/*gameWon will be assigned true if the current player has 3 in-a-row 
		* in any row, column or diagonal. 
		*/
		if(checkRowsForWin()||checkColsForWin()||checkDiagnolsForWin()){
			gameWon = true;
		}
		return gameWon; 
	}
	
	
	/**
	 * @return boolean Returns true or false if rows match
	 * This method will return true if any of the rows contain 
	 * 'X' or 'O'  in all section
	 */
	public boolean checkRowsForWin(){
		
		boolean rowsMatched = false;
		//check for all three rows
		for (int i = 0; i<3 ; i++ ) {
			if (checkValue(board[i][0], board[i][1], board[i][2])){
				rowsMatched = true;
				return rowsMatched;
			}
		}
		return rowsMatched;
	}
	
	
	/**
	 * @return boolean Returns true or false if columns match
	 * This method will return true if any of the columns contain 
	 * 'X' or 'O'  in all section
	 */
	public boolean checkColsForWin() {
		
		boolean colsMatched = false;
		//check for all three columns
		for (int i = 0; i<3 ; ++i ) {
			if (checkValue(board[0][i], board[1][i], board[2][i])){
				colsMatched = true;
				return colsMatched;
			}
		}
		return colsMatched;
	}
	
	
	/**
	 * @return boolean Returns true or false if diagonals match
	 * This method will return true if any of the columns contain 
	 * 'X' or 'O'  in all section
	 */
	public boolean checkDiagnolsForWin() {

		boolean diaMatched = false;
		//check for right diagonal and left diagonal
		if(checkValue(board[0][0], board[1][1], board[2][2])||
				checkValue(board[0][2], board[1][1], board[2][0])){
			diaMatched = true;
		}
		return diaMatched;
	}
	
	
	/**
	 * @param val1, val2, val3
	 * @return boolean Returns true or false if value match
	 * This method will return true if all three value matches 
	 */
	public boolean checkValue( char val1, char val2, char val3){
		//checking if all values are equal and are either 'X' or 'O'
		if(((val1 == val2) && (val2 == val3) && (val1 == val3) && (val1 == 'X' || val1 == 'O'))){
			return true;
		}else
			return false;
	}
	
	
	/**
	 * @return boolean isStalenate
	 * This method returns true if there are no places left to move
	 */
	public boolean stalemate() {
	    
		boolean isStalemate = true;
		/*
		 * Assign false to stalemate if there are places 
		 * to move on the board.   
		 */
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if(board[i][j] == ' '){
					isStalemate = false;
					return isStalemate;
				}
			}
		}
		return isStalemate;
	}
	
	
	/**
	 * @return char player
	 * This method returns the current player
	 */
	public char getPlayer() {
		return player;
	}
	
	
	/**
	 * @return nothing 
	 * This method  print the whole board with moves made until last move
	 */
	public void print(String input) {
		System.out.println();
		System.out.println("\t   1   2   3");
		System.out.println();
		System.out.println("\tA  "+ board[0][0] +" | "+ board[0][1]+ " | " + board[0][2]);
		System.out.println("\t  -----------");
		System.out.println("\tB  "+ board[1][0] +" | " + board[1][1]+ " | " + board[1][2]);
		System.out.println("\t  -----------");
		System.out.println("\tC  "+ board[2][0] +" | " + board[2][1]+ " | " + board[2][2]);
		System.out.println();
	}
	
	
	/**
	 * @return boolean 
	 * This method will return true if input is valid for TicTacToe Game
	 */
	public boolean ValidateInput(String input){
		
		boolean validInput = false;
		//check input is empty
		if (input== null || input.isEmpty()) {
			System.out.println("Input cant be empty");
			return validInput;			
		}else if (input.trim().length()== 1 || input.trim().length()> 2 || input.trim().length()== 0) {
			//this loop checked if input is less than or greater than 2, input is invalid
			System.out.println("Invalid Input. Length should be 2. Please provide the valid input.");
			return validInput;
		}else if (input.trim().length()== 2) {
			//this condition checks if input is of pattern A1,a1,B1,b2 etc
			Pattern pattern = Pattern.compile("[a-cA-C][1-3]");
			Matcher checkMatcher = pattern.matcher(input);
			boolean find = checkMatcher.matches();
			if(find){
				validInput = true;
				return validInput;
			}else{
				//This condition is to check if input is 2 but doesn't follow the pattern
				System.out.println("Invalid Input. Input should be of format A1/A2/A3 etc. Please provide the valid input.");
			}
		}
		return validInput;
		
	}
	
	
	/**
	 * @param args
	 * This method is the starting point of the program and args will be the input from user
	 */
	public static void main(String[] args) {
		
		//Object to scan the input entered by user
		Scanner scanner = new Scanner(System.in);
		
		//object creation of TicTacToe
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to tic-tac-toe");
		System.out.println("Enter coordinates for your move following the X and O prompts");
		
		//Print the game
		game.print("");
		
		//Looping until player wins the game or game is over
		while(!(game.won())&& !game.stalemate()) {
			
			//get the input from player
			System.out.printf("%s : ", game.getPlayer());
			String playerMove =  scanner.next().toUpperCase();
					
			//check the input if it is valid or not and loop until the input is valid
			if(game.ValidateInput(playerMove)){
				//play the game when input is valid and the move has not been already made
				if(game.play(playerMove)){
					//check if the current wins the game after moving the move
					if(game.won()){
						//break from loop if player wins the game
						break;
					}else{
						//if current player doesn't win the game, switch the turn
						game.switchTurn();
						//Prompt player for their move
					}
				}
			}
			
		}
		/*
		 * if current player wins the game, print the player
		 * otherwise print the game is over
		 */
		if(game.won()){
			System.out.println("Player "+game.getPlayer()+" Wins!!!!");
		} else {
			System.out.println("Stalemate");
		}
		
		scanner.close();
	} 
	
}

