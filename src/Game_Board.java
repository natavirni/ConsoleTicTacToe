
public class Game_Board {
	
	
	private final int ROW = 3;
	private final int COL = 3;
	private static int counter = 0;
	private char[][] board = new char[ROW][COL]; 
	static boolean isInputValid = true;
	
	public void newGame() {
		for(int row = 0; row < ROW; row++) {
			for(int col = 0; col < COL; col++) {
				board[row][col] = ' ';
			}
		}
	}
	
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
	
	public void getUserChoice(Position p) {
		if(board[p.x][p.y] == 'X' || board[p.x][p.y] == 'O') {
			System.out.println("This is an illegal move. Please try again.");
			isInputValid = false;
			Player_turn.isPlayer1 = !Player_turn.isPlayer1; 
		}else
			board[p.x][p.y] = p.input;
			isInputValid = true;
			counter++;
	}
	
	private boolean checkPlayerInput(char first, char second, char third) {
		return (first != ' ' && first == second && second == third);
	}
	
	private boolean checkRows() {
		for(int row = 0; row < ROW; row++) {
			if(checkPlayerInput(board[row][0], board[row][1], board[row][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkCols() {
		for(int col = 0; col < COL; col++) {
			if(checkPlayerInput(board[0][col], board[1][col], board[2][col]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDia() {
		return ((checkPlayerInput(board[0][0], board[1][1], board[2][2]) == true) || (checkPlayerInput(board[0][2], board[1][1], board[0][2]) == true));
	}
	
	public boolean isGameOver() {
		return (checkRows() || checkCols() || checkDia());
	}

	public boolean checkCatGame() {
		return(counter == 9 && (checkRows() || checkCols() || checkDia()) == false);
	}
	
	public void winner() {
		System.out.println(Player_turn.getPlayer() + " Player Wins!");
		makeBoard();
	}
	
	public void catgame() {
		System.out.println("Cat's Game!");
		makeBoard();
	}
}
