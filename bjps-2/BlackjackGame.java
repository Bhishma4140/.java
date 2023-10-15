import java.util.Scanner;


public class BlackjackGame {
	
	Scanner sc = new Scanner(System.in);//p
	int users; 
	Player[] players;
	Deck deck;
	Dealer dealer = new Dealer();

	public void Game(){
		String names;
		System.out.println("Welcome to Blackjack");
		System.out.println();
		
		do {
			System.out.print("How many people are playing (1-6) ");
			users = sc.nextInt();
			

		} while (users > 6 || users < 0);

		players = new Player[users];
		deck = new Deck();

		
		for (int i = 0; i < users; i++) {
			System.out.print("What is player " + (i + 1) + " name ");
			names = sc.next();
			players[i] = new Player();
			players[i].setName(names);
		}
	}
	
	
	public void shuffle() throws InvalidDeckPositionException, InvalidCardSuitException, InvalidCardValueException {
		deck.shuffle();
		
	}

	
	public void getBets(){
		int betValue;
		
		for (int i =0; i < users; i++) {  	
			if (players[i].getBank() > 0) {
			do {
				System.out.print("How much do you want to bet " + players[i].getName()  + (" (1-" + players[i].getBank()) + ")? " );
				betValue = sc.nextInt();
				players[i].setBet(betValue);
			} while (!( betValue > 0 && betValue <= players[i].getBank()));
			System.out.println("");
			}

		}

	}
	
	
	public void dealCards(){
		for (int j = 0; j < 2; j++) {
			for (int i =0; i < users; i++) {
				if(players[i].getBank() > 0)
				{
				players[i].addCard(deck.nextCard());
				}
			}

			dealer.addCard(deck.nextCard());
		}
	}
	
	
	public void checkBlackjack(){
		//System.out.println();

		if (dealer.isBlackjack() ) {
			System.out.println("Dealer has BlackJack!");
			for (int i =0; i < users; i++) {
				if (players[i].getTotal() == 21 ) {
					System.out.println(players[i].getName() + " pushes");
					players[i].push();
				} else {
					System.out.println(players[i].getName() + " loses");
					players[i].bust();
				}	
			}
		} else {
			if (dealer.peek() ) {
				System.out.println("Dealer peeks and does not have a BlackJack");
			}

			for (int i =0; i < users; i++) {
				if (players[i].getTotal() == 21 ) {
					System.out.println(players[i].getName() + " has blackjack!");
					players[i].blackjack();
				}
			}
		}		
	}
	
	
	public void hitOrStand() {
		String command;
		char c;
		for (int i = 0; i < users; i++) {
			if ( players[i].getBet() > 0 ) {
				System.out.println();
				System.out.println(players[i].getName() + " has " + players[i].getHandString());

				do {
					do {
						System.out.print(players[i].getName() + " (H)it or (S)tand? ");
						command = sc.next();
						c = command.toUpperCase().charAt(0);
					} while ( ! ( c == 'H' || c == 'S' ) );
					if ( c == 'H' ) {
						players[i].addCard(deck.nextCard());
						System.out.println(players[i].getName() + " has " + players[i].getHandString());
					}
				} while (c != 'S' && players[i].getTotal() <= 21 );
			}
		}
	}
	
	
	public void dealerPlays() {
		boolean isSomePlayerStillInTheGame = false;
		for (int i =0; i < users && isSomePlayerStillInTheGame == false; i++){
			if (players[i].getBet() > 0 && players[i].getTotal() <= 21 ) {
				isSomePlayerStillInTheGame = true;
			}
		}
		if (isSomePlayerStillInTheGame) {
			dealer.dealerPlay(deck);
		}
	}
	
	
	public void settleBets() {
		System.out.println();

		for (int i = 0; i < users; i++) {
			if (players[i].getBet() > 0 ) {
				if( players[i].getTotal() > 21 ) {
					System.out.println(players[i].getName() + " has busted");
					players[i].bust();
				} else if ( players[i].getTotal() == dealer.calculateTotal() ) {
					System.out.println(players[i].getName() + " has pushed");
					players[i].push();
				} else if ( players[i].getTotal() < dealer.calculateTotal() && dealer.calculateTotal() <= 21 ) {
					System.out.println(players[i].getName() + " has lost");
					players[i].loss();
				} else if (players[i].getTotal() == 21) {
					System.out.println(players[i].getName() + " has won with blackjack!");
					players[i].blackjack();
				} else {
					System.out.println(players[i].getName() + " has won");
					players[i].win();
					
				}
			}
		}

	}

	
	public void printStatus() {
		for (int i = 0; i < users; i++) {
			if(players[i].getBank() > 0)
			{
			System.out.println(players[i].getName() + " has " + players[i].getHandString());
			}
		}
		System.out.println("Dealer has " + dealer.getHandString(true, true));
	}
	
	
	public void printMoney() {
		for (int i = 0; i < users; i++) {
			if(players[i].getBank() > 0)
			{
			System.out.println(players[i].getName() + " has " + players[i].getBank());
			}
			if(players[i].getBank() == 0)
			{
			System.out.println(players[i].getName() + " has " + players[i].getBank() + " and is out of the game.");
			players[i].removeFromGame();
			}
		}
	}

	public void clearHands() {
		for (int i = 0; i < users; i++) {
			players[i].clearHand();
		}
		dealer.clearHand();

	}
	
	
	public boolean playAgain() {
		String command;
		char c;
		Boolean playState = true;
		if(forceEnd()) {
			playState = false;	
		}
		else {
			do {
				System.out.println("");
				System.out.print("Do you want to play again (Y) or (N) ");
				command = sc.next();
				c = command.toUpperCase().charAt(0);
			} while ( ! ( c == 'Y' || c == 'N' ) );
			if(c == 'N')
			{
				playState = false;
			}
		}
		return playState;
	}
	

	public boolean forceEnd() {
		boolean end = false;
		int endCount = 0;
		
		for (int i = 0; i < users; i++) {
			if(players[i].getBank() == -1)
			{
				endCount++;
			}
		}
		if(endCount == users)
		{
			end = true;
		}
		if(end)
		{
			System.out.println("");
			System.out.println("All players have lost and the game ends.");
		}
		
		return end;
	}

		public void endGame() {
			int endAmount;
			String endState = " no change.";
			System.out.println("");
			for (int i = 0; i < users; i++) {
				if(players[i].getBank() == -1)
				{
					players[i].resetBank();
				}
				endAmount = players[i].getBank() - 100;
				if(endAmount > 0)
				{
					endState = " gain of ";
				}
				else if(endAmount < 0)
				{
					endState = " loss of ";
				}
				System.out.println(players[i].getName() + " has ended the game with " + players[i].getBank() + ".");
				if(endState != " no change.")
				{
				System.out.println("A" + endState + Math.abs(endAmount) + ".");
				}
				else
				{
				System.out.println("No change from their starting value.");	
				}
				System.out.println("");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("Thank you for playing!");
		}


} 
