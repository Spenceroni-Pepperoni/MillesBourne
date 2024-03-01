package _MillesBourne;

public class Computer extends Player{
	
	
	public Computer() {
		super();
	}
	
	
	public void takeTurn() {
		if(hasHazard() == false) {
			if(speedLimit() == true) {
				int playIndex = -1;
				for(Card hand : deck) {
					if(hand.getCardType().equals("Remedy") || hand.getCardType().equals("Safety")) {
						
					}
				}
			}
		}
	}
}
