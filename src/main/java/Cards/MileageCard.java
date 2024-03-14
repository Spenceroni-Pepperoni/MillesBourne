package Cards;

public class MileageCard extends Card{
    private int numMiles;

    public MileageCard(String name, int numMiles){
        super(name);
        this.numMiles = numMiles;
    }


    /**
     * Method that plays the action of the card
     */
    @Override
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
        return  numMiles + " Miles";
    }

    public int getMileage() {
        return numMiles;
    }

    @Override
    public String getFileName(){
        return "" + numMiles + ".png";
    }
}
