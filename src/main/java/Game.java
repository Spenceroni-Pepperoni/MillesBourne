import java.util.ArrayList;
import Cards.*;

public class Game {
	private ArrayList<Card> pile;
	private ArrayList<Card> discard;
	private int[] players;
	
	public Game(int[] players) {
		this.players = players;
		pile = new ArrayList<Card>();
		discard = new ArrayList<Card>();
	}
	
	public void startGame() {
		createCards();
	}
	
	private void createCards() {
		for (int i = 0; i < 14; i++) {
			if (i < 3) {
				pile.add(new HazardCard("Accident"));
				pile.add(new HazardCard("Out of Gas"));
				pile.add(new HazardCard("Flat Tire"));
			}
			if (i < 4) {
				pile.add(new HazardCard("Speed Limit"));
			}
		}
	}
}
