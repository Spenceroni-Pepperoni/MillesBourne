package Cards;

public class HazardCard extends Card{

    public HazardCard(String name){
        super(name);
    }

    /**
     * Method that plays the action of the card
     */

    public void playCard() {

    }


    @Override
    public boolean getCanPlay() {
        return false;
    }

    @Override
    public String getCardType() {
        return null;
    }

	@Override
	public int getMileage() {
		return 0;
	}
}