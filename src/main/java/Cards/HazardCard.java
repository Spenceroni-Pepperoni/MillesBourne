package Cards;

public class HazardCard extends Card{

    public HazardCard(String name){
        super(name);
    }

    /**
     * Method that plays the action of the card
     */
    @Override
    void playCard() {

    }


    @Override
    boolean getCanPlay() {
        return false;
    }

    @Override
    String getCardType() {
        return null;
    }
}