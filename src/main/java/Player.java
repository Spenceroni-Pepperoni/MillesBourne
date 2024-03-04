import java.util.*;

public class Player {
	private ArrayList<Card> deck;

	protected ArrayList<Card> deck;
	private int mileage;
	private boolean turn;
	private ArrayList<Card> hazards;

	public void receiveHazard(Card card) {
		hazards.add(card);
	}

	public Card discard(int index) {
		Card temp = deck.get(index);
		deck.remove(index);
		return temp;
	}

	public boolean speedLimit() {
		for(Card hazard : hazards) {
			if(hazard.getName().equals("speedLimit")) {
				return false;
			}
		}

	}

	public boolean hasHazard() {
		for(Card hazard : hazards) {
			if(!hazard.getName().equals("speedLimit")) {
				return true;
			}
		}
		return false;
	}
}	public boolean getTurn() {
		return isTurn;
	}
	
	public Card discard(int cardIndex) {
		
	}
}
