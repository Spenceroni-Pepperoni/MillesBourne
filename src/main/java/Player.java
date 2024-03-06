import java.util.*;
import Cards.*;

public class Player {

	protected ArrayList<Card> deck;
	protected int mileage;
	private boolean turn;
	private ArrayList<Card> hazards;
	
	public void drawPile() {
		deck.add(Game.getPileCard()); //method isn't in decomp but might be needed
	}
	
	public void drawDiscard() {
		deck.add(Game.getDiscardCard()); //same here
	}
	
	public int getMileage() {
		return mileage;
	}

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
				return true;
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
	
	public boolean getTurn() {
		return isTurn;
	}
}
