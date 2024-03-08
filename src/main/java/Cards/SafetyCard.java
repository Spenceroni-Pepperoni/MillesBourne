package Cards;

public class SafetyCard extends Card{

    public SafetyCard(String name){
        super(name);
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
        return null;
    }

	@Override
	public int getMileage() {
		return 0;
	}
}
