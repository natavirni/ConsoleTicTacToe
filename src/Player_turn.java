import java.util.Scanner;

public class Player_turn {

	static Scanner input = new Scanner(System.in);
	static boolean isPlayer1 = true;
	private static char player;
	
	public static void whichPlayer() {
		if(isPlayer1 == true) {
			player = 'X';
			System.out.println("Player 1 turn 'X'");
		}else {
			player = 'O';
			System.out.println("Player 2 turn 'O'");
		}
	}
	
	public static void askUser(Game_Board gameboard) {
		Position p = new Position();
	
		System.out.println("Which Row would you like?");
		p.x = input.nextInt(); 
	
		System.out.println("Which Col would you like?");
		p.y = input.nextInt(); 
		
		isPlayer1 = !isPlayer1; 
		p.input = player;
		gameboard.getUserChoice(p);
	}

	public static char getPlayer() {
		return player;
	}

}
