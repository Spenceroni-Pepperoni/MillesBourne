package _MillesBourne;

public class Computer extends Player{
	
	
	public Computer() {
		super();
	}
	
	
	public void takeTurn() {
		if(hasHazard() == false) {
			if(speedLimit() == true) {
				int playIndex = -1;
				int max = 0;
				for(int i =0; i<deck.size(); i++) {
					if(deck.get(i).getCardType().equals("Safety")) {
						if(deck.get(i).canPlay()) {
							playIndex = i;
						}
					}
				}

				}
			}
		}
	}
}