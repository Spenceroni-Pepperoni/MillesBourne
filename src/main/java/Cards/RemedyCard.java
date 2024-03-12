package Cards;

public class RemedyCard extends Card{

    public RemedyCard(String name){
        super(name);
    }

    /**
     * Method that plays the action of the card
     */

    public void playCard() {

    }

    /**
     * @return if the card is able to be played
     */
    @Override
    public boolean getCanPlay() {
        return false;
    }

    /**
     * @return the Card type
     */
    @Override
    public String getCardType() {
        return null;
    }

	@Override
	public int getMileage() {
		return 0;
	}
}
