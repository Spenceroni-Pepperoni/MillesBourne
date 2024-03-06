
public class Computer extends Player {


    public Computer() {
        super();
    }


    public void takeTurn() {
        if (!hasHazard()) {
            if (!speedLimit()) {
                int playIndex = -1;
                for (Card hand : deck) {
                    if (hand.getCardType().equals("Remedy") || hand.getCardType().equals("Safety")) {

                        int max = 0;
                        for (int i = 0; i < deck.size(); i++) {
                            if (deck.get(i).getCardType().equals("Safety")) {
                                if (deck.get(i).canPlay()) {
                                    playIndex = i;
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        }

    }

}
