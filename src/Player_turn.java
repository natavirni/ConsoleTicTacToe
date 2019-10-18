import java.util.Scanner;

public class Player_turn {
	//======================================================
	//Allows for input
	static Scanner input = new Scanner(System.in);
	static boolean isPlayer1 = true;
	private static char player;
	//=====================================================
	//Determines which player it is
	public static void whichPlayer() {
		if(isPlayer1 == true) {
			player = 'X';
			System.out.println("Player 1 turn 'X'");
		}else {
			player = 'O';
			System.out.println("Player 2 turn 'O'");
		}
	}
	//======================================================
	//Asks for user's X and O's input
	public static void askUser(Game_Board gameboard) {
		//Row and Col
		int x;
		int y;
		//Asks the user for which row and col he/she wants
		System.out.println("Which Row would you like?");
		x = input.nextInt();
		System.out.println("Which Col would you like?");
		y = input.nextInt();
		isPlayer1 = !isPlayer1; //changes the player to the other
		//The player's char is placed into the array only if it is open
		gameboard.getUserChoice(x, y, player);
	}
	//======================================================
	//getter for the player
	public static char getPlayer() {
		return player;
	}
	//=========================================================
}
