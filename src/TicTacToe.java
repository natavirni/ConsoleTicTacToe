
public class TicTacToe {

	public static void main(String[] args) {
		
		boolean gameActive = true;
		Game_Board game = new Game_Board();
		game.newGame();
		
		while(gameActive == true){
			game.makeBoard();
			Player_turn.whichPlayer();
			do{
				Player_turn.askUser(game);
			  }while(game.isInputValid == false);
			
			if(game.isGameOver()) {
				game.winner();
				gameActive = false;
			}else if(game.checkCatGame()) {
				game.catgame();
				gameActive = false;
			}
		}
	}
	
}
