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
		
	}
}
