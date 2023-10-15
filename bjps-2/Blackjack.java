
import java.util.*;

public class Blackjack {

	public static void main(String[] args) throws Exception {

		BlackjackGame game = new BlackjackGame();

		game.Game();
		do {
			game.shuffle();
			game.getBets();
			game.dealCards();
			game.printStatus();
			game.checkBlackjack();
			game.hitOrStand();
			game.dealerPlays();
			game.settleBets();
			game.printMoney();
			game.clearHands();
		} while (game.playAgain());
		
	
		
		
		
	}

}