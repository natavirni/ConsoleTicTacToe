
public class Game_Board {
	//======================================================
	//Variables
	private final int ROW = 3;
	private final int COL = 3;
	private static int counter = 0;
	private char[][] board = new char[ROW][COL]; //Tictactoe 2d array board
	static boolean isInputValid = true;
	//=====================================================
	//Clears the board and empties the array/changes to "blank"
	public void newGame() {
		for(int row = 0; row < ROW; row++) {
			for(int col = 0; col < COL; col++) {
				board[row][col] = ' ';
			}
		}
	}
	//=====================================================
	//Creates the board
	public void makeBoard() {
		System.out.println("--0-1-2--");
		for(int row = 0; row < ROW; row++) {
			if(row == 0) {
				System.out.print('0');
			}else if(row == 1) {
				System.out.print('1');
			}else if(row == 2) {
				System.out.print('2');
			}
			System.out.print('|');
			for(int col = 0; col < COL; col++) {
				System.out.print(board[row][col]);
				System.out.print('|');
			}
			System.out.println();
		}
		System.out.println("---------");
	}
	//======================================================
	//Stores the user input into array
	public void getUserChoice(int x, int y, char input) {
		if(board[x][y] == 'X' || board[x][y] == 'O') {
			//Lets the same player try again
			System.out.println("This is an illegal move. Please try again.");
			isInputValid = false;
			Player_turn.isPlayer1 = !Player_turn.isPlayer1; //keeps the same player
		}else
			board[x][y] = input;
			isInputValid = true;
			counter++;
	}
	//======================================================
	//Checks if there are three in a row
	private boolean checkPlayerInput(char first, char second, char third) {
		return (first != ' ' && first == second && second == third);
	}
	//=========================================================
	//Checks the row
	private boolean checkRows() {
		for(int row = 0; row < ROW; row++) {
			if(checkPlayerInput(board[row][0], board[row][1], board[row][2]) == true) {
				return true;
			}
		}
		return false;
	}
	//=============================================================
	//Check the cols
	private boolean checkCols() {
		for(int col = 0; col < COL; col++) {
			if(checkPlayerInput(board[0][col], board[1][col], board[2][col]) == true) {
				return true;
			}
		}
		return false;
	}
	//============================================================
	//Check for the diagonals
	private boolean checkDia() {
		return ((checkPlayerInput(board[0][0], board[1][1], board[2][2]) == true) || (checkPlayerInput(board[0][2], board[1][1], board[0][2]) == true));
	}
	//===============================================================
	//Checks if there's any winners
	public boolean isGameOver() {
		return (checkRows() || checkCols() || checkDia());
	}
	//===============================================================
	//Finds if there's a cat game
	public boolean checkCatGame() {
		return(counter == 9 && (checkRows() || checkCols() || checkDia()) == false);
	}
	//=================================================================
	//Displays the winner
	public void winner() {
		System.out.println(Player_turn.getPlayer() + " Player Wins!");
		makeBoard();
	}
	//==============================================================
	//prints out cat game
	public void catgame() {
		System.out.println("Cat's Game!");
		makeBoard();
	}
	//=====================================================================
	
}
