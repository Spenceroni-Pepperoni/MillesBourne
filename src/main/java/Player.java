import java.util.*;
import Cards.*;

public abstract class Player {

	protected ArrayList<Card> deck;
	protected int mileage;
	private boolean isTurn;
	private ArrayList<Card> hazards;
	private ArrayList<Card> safeties;
	private boolean started;

	public Player(){
		deck = new ArrayList<Card>();
		mileage = 0;
		hazards = new ArrayList<Card>();
		safeties = new ArrayList<Card>();
		isTurn = false;

	}

	public void drawPile() {
		deck.add(Game.getPileCard()); //method isn't in decomp but might be needed
	}
	
	public void drawDiscard() {
		deck.add(Game.getDiscardCard()); //same here
	}

	public abstract Card takeTurn();
	
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
			if(!hazard.getCardName().equals("speedLimit")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getTurn() {
		return isTurn;
	}

}
