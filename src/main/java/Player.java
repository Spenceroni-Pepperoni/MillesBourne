import java.util.*;
import Cards.*;

abstract public class Player {

	protected ArrayList<Card> deck;
	protected int mileage;
	private boolean turn;
	private ArrayList<Card> hazards;
	private ArrayList<Card> safeties;
	
	abstract public Card takeTurn();
	
	public void drawPile() {
		//deck.add(Game.getPileCard()); //method isn't in decomp but might be needed
	}
	
	public void drawDiscard() {
		//deck.add(Game.getDiscardCard()); //same here
	}
	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int miles){
		mileage = miles;
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
			if(hazard.getCardName().equals("Speed Limit")) {
				return true;
			}
		}
		return false;
	}

	public boolean hasHazard() {
		for(Card hazard : hazards) {
			if(!hazard.getCardType().equals("speedLimit")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getTurn() {
		return turn;
	}
}
