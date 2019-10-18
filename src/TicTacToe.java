
public class TicTacToe {

	public static void main(String[] args) {
		//===================================================================
		boolean gameActive = true;
		//Constrcutor
		Game_Board game = new Game_Board();
		//===================================================================
		//loops the tic tac toe game while the game is active
		game.newGame(); //Empties out the arrays
		while(gameActive == true){
			game.makeBoard();
			//Player turn
			Player_turn.whichPlayer();
			do {
				Player_turn.askUser(game);
			}while(game.isInputValid == false);
			
			//Checks if the game is over
			if(game.isGameOver()) {
				game.winner();
				gameActive = false;
			}else if(game.checkCatGame()) {
				game.catgame();
				gameActive = false;
			}
		}
	}
	//==========================================================================
}
