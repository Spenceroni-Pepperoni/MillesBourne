import java.util.ArrayList;
import Cards.*;

public class Game {
	private ArrayList<Card> pile;
	private ArrayList<Card> discard;
	private Player[] players;
	private int turnNum;
	
	public Game(Player[] players) {
		this.players = players;
		pile = new ArrayList<Card>();
		discard = new ArrayList<Card>();
		turnNum = 0;
	}
	
	public void startGame() {
		createCards();
		shuffleDeck();
		System.out.println(pile);
	}
	
	//adds all cards to game
	private void createCards() {
		for (int i = 0; i < 14; i++) {
			if (i == 0) {
				pile.add(new SafetyCard("Driving Ace"));
				pile.add(new SafetyCard("Extra Tank"));
				pile.add(new SafetyCard("Puncture Proof"));
				pile.add(new SafetyCard("Emergency Vehicle"));
			}
			if (i < 3) {
				pile.add(new HazardCard("Accident"));
				pile.add(new HazardCard("Out of Gas"));
				pile.add(new HazardCard("Flat Tire"));
			}
			if (i < 4) {
				pile.add(new HazardCard("Speed Limit"));
				pile.add(new MileageCard("200 Miles", 200));
			}
			if (i < 5) {
				pile.add(new HazardCard("Stop"));
			}
			if (i < 6) {
				pile.add(new RemedyCard("Repairs"));
				pile.add(new RemedyCard("Gasoline"));
				pile.add(new RemedyCard("Spare Tire"));
				pile.add(new RemedyCard("End of Speed Limit"));
			}
			if (i < 10) {
				pile.add(new MileageCard("25 Miles", 25));
				pile.add(new MileageCard("50 Miles", 50));
				pile.add(new MileageCard("75 Miles", 75));
			}
			if (i < 12) {
				pile.add(new MileageCard("100 Miles", 100));
			}
			pile.add(new RemedyCard("Go"));
		}
	}
	
	public void loadGame() {
		
	}
	
	public void saveGame() {
		
	}
	
	public void restartGame() {
		
	}
	
	public int getTurnNum() {
		return turnNum;
	}
	
	public void shuffleDeck() {
		for (int i = 0; i < 150; i++) {
			int j = (int)(Math.random() * pile.size());
			int k = (int)(Math.random() * pile.size());
			
			Card temp = pile.get(j);
			pile.set(j, pile.get(k));
			pile.set(k, temp);
		}
	}
	
	public void shuffleDeck(ArrayList<Card> cards) {
		
	}
}
