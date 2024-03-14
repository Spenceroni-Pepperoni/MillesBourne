import java.util.ArrayList;
import Cards.*;

public class Game {
	private static ArrayList<Card> pile;
	private static ArrayList<Card> discard;
	private Computer comp;
	private HumanPlayer user;
	private int turnNum;
	boolean gameOver;
	
	public Game(String name) {
		comp = new Computer();
		user = new HumanPlayer(name);
		pile = new ArrayList<Card>();
		discard = new ArrayList<Card>();
		turnNum = 0;
	}
	
	public Game(HumanPlayer user, Computer comp, ArrayList<Card> p, ArrayList<Card> d, int t) {
		this.user = user;
		this.comp = comp;
		pile = p;
		discard = d;
		turnNum = t;
	}
	
	public void startGame() {
		createCards();
		shuffleDeck();
		boolean gameOver = false;
		for(int i = 0; i<7; i++){
			user.drawPile();
			comp.drawPile();
		}
		gameOver = false;

		
//		while (!gameOver) {
//			discard.add(user.takeTurn());
//			discard.add(comp.takeTurn());
//			turnNum++;
//			if (pile.size() == 0) {
//				gameOver = true;
//			}
//		}
	}


	public boolean over(){
		return gameOver;
	}
	public void turn(){
		Card userCard = user.takeTurn();
		if(userCard.getCanPlay()){

		}else{
			discard.add(userCard);
		}
		if (pile.size() == 0) {
			gameOver = true;
			return;
		}
		Card compCard = comp.takeTurn();
		if(compCard.getCanPlay()){

		}else{
			discard.add(compCard);
		}
		if (pile.size() == 0) {
			gameOver = true;
			return;
		}
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
				pile.add(new RemedyCard("Repair"));
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
			pile.add(new RemedyCard("Drive"));
		}
	}

	public ArrayList<Card> getUserDeck(){
		return user.deck;
	}
	
	public void loadGame(Game g) {
		this.user = g.user;
		this.comp = g.comp;
		this.pile = g.pile;
		this.discard = g.discard;
		this.turnNum = g.turnNum;
	}
	
	public Game saveGame() {
		return new Game(user, comp, pile, discard, turnNum);
	}
	
	public void restartGame() {
		for (int i = 0; i > pile.size(); i--) {
			pile.remove(i);
			i--;
		}
		for (int i = 0; i > discard.size(); i--) {
			discard.remove(i);
			i--;
		}
		user.setMileage(0);
		comp.setMileage(0);
		startGame();
		turnNum = 0;
	}
	
	public int getTurnNum() {
		return turnNum;
	}
	
	public static Card getPileCard() {
		Card c = pile.get(pile.size() - 1);
		pile.remove(pile.size() - 1);
		return c;
	}
	
	public static Card getDiscardCard() {
		Card c = discard.get(discard.size() - 1);
		discard.remove(discard.size() - 1);
		return c;
	}

	public static Card peekDiscardCard() {
		Card c = discard.get(discard.size() - 1);
		return c;
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
	
	public ArrayList<Card> shuffleDeck(ArrayList<Card> c) {
		ArrayList<Card> cards = c;
		for (int i = 0; i < 150; i++) {
			int j = (int)(Math.random() * cards.size());
			int k = (int)(Math.random() * cards.size());
			
			Card temp = cards.get(j);
			cards.set(j, cards.get(k));
			cards.set(k, temp);
		}
		return cards;
	}
}