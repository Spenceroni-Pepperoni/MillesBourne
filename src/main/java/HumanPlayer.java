import Cards.*;

public class HumanPlayer extends Player {
	String name;
	
	public HumanPlayer(String name) {
		super();
		this.name = name;
	}


	public void draw(int drawPile){
		if (drawPile == 0) {
			drawPile();
		} else {
			drawDiscard();
		}
	}


	public Card playCard(int playIndex){
		if(!deck.get(playIndex).getCanPlay()) {
			//change playIndex
			return null;
		}

		return discard(playIndex);
	}
	public Card takeTurn() {
		int playIndex = 0;
		int drawPileOrDiscard = 0; //0 for pile, 1 for discard
		
		//something here to get user input for variables
		
		while (!deck.get(playIndex).getCanPlay()) {
			//change playIndex
		}

		if (deck.get(playIndex).getCardType().equals("25 Miles")) {
			mileage += 25;
		} else if (deck.get(playIndex).getCardType().equals("50 Miles")) {
			mileage += 50;
		} else if (deck.get(playIndex).getCardType().equals("75 Miles")) {
			mileage += 75;
		} else if (deck.get(playIndex).getCardType().equals("100 Miles")) {
			mileage += 100;
		} else if (deck.get(playIndex).getCardType().equals("200 Miles")) {
			mileage += 200;
		}
		
		if (drawPileOrDiscard == 0) {
			drawPile();
		} else {
			drawDiscard();
		}
		
		return discard(playIndex);
	}
	
	public String getPlayerName() {
		return name;
	}
}
