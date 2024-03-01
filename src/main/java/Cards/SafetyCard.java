package Cards;

public class SafetyCard extends Card{

    public SafetyCard(String name){
        super(name);
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
}
