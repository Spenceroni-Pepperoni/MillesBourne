package _MillesBourne;
import java.util.*;

public class Player {
	private ArrayList<Card> deck;
	private int mileage;
	private boolean turn;
	private ArrayList<Card> hazards;
	
	public Player() {
		deck = new ArrayList<Card>();
		mileage = 0;
		turn = false;
	}
	
	public void drawPile(Card draw) {
		deck.add(draw);
	}
	
	public void drawDiscard(Card draw) {
		deck.add(draw);
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public Card playCard(int index) {
		Card temp = deck.get(index);
		deck.remove(index);
		return temp;
	}
	
	public void receiveHazard(Card card) {
		hazards.add(card);
	}
	
	public boolean speedLimit() {
		for(Card hazard : hazards) {
			if(hazard.getName().equals("speedLimit")) {
				return true;
			}
		}
		return false;
	}
}
