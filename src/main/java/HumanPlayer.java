
public class HumanPlayer extends Player {
	String name;
	
	public HumanPlayer(String name) {
		super();
		this.name = name;
	}
	
	public Card takeTurn() {
		int playIndex = 0;
		int drawPileOrDiscard = 0; //0 for pile, 1 for discard
		
		//something here to get user input for variables
		
		if (deck.get(playIndex).getCanPlay()) {
			return discard(playIndex);
		}
		
		if (drawPileOrDiscard == 0) {
			drawPile();
		} else {
			drawDiscard();
		}
	}
	
	public String getPlayerName() {
		return name;
	}
}
