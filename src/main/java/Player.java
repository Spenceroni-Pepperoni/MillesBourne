//-----------------------------------------------------------------------------
// Player class: simulates a player in the MilesQuest game
//-----------------------------------------------------------------------------
public class Player {
	private int[] deck = new int[6];
	private boolean isTurn;
	private int mileage;
	private int deckSize = 0;
	private String currentHazard;
	
	public Player() {
		mileage = 0;
	}
	
	public void drawPile() {
		if (deckSize < 5) {
			deck[deckSize] = Game.getPileCard(); //this method isn't in decomp but we might need it
			deckSize++;
		}
	}
	
	public void drawDiscard() {
		if (deckSize < 5) {
			deck[deckSize] = Game.getDiscardCard(); //same for this one
			deckSize++;
		}
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public boolean playCard(int cardIndex) {
		
	}
	
	public void receiveHazard(Card card) {
		
	}
	
	public boolean getTurn() {
		return isTurn;
	}
	
	public Card discard(int cardIndex) {
		
	}
}
