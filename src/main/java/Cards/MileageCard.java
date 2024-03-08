package Cards;

public class MileageCard extends Card{
    int numMiles;

    public MileageCard(String name, int numMiles){
        super(name);
        this.numMiles = numMiles;
    }

    /**
     * Method that plays the action of the card
     */
    @Override
    void playCard() {

    }

    /**
     * @return if the card is able to be played
     */
    @Override
    boolean getCanPlay() {
        return false;
    }

    /**
     * @return the Card type
     */
    @Override
    String getCardType() {
        return  numMiles + " Miles";
    }
    
    @Override
    public int getMileage() {
    	return numMiles;
    }
}