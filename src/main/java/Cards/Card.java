package Cards;

public abstract class Card {

    protected String cardName;
    protected boolean hasBeenPlayed;

    /**
     * Constructor for Card Class
     * @param name name of the Card
     */
    Card(String name){
        this.cardName = name;
        hasBeenPlayed = false;
    }

    /**
     * @return if the card is able to be played
     */
    abstract boolean getCanPlay();

    /**
     * @return the Card type
     */
    abstract String getCardType();

    /**
     * @return Get the name of the card
     */
    public String getCardName() {
        return cardName;
    }

}
