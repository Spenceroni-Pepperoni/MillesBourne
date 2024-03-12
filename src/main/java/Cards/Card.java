package Cards;

public abstract class Card {

    protected String cardName;
    protected boolean hasBeenPlayed;

    /**
     * Constructor for Card Class
     * @param name name of the Card
     */
    public Card(String name){
        this.cardName = name;
        hasBeenPlayed = false;
    }

    /**
     * Method that plays the action of the card
     */
    public abstract void playCard();


    /**
     * @return if the card is able to be played
     */
    public abstract boolean getCanPlay();



    /**
     * @return the Card type
     */
    public abstract String getCardType();

    /**
     * @return Get the name of the card
     */
    public String getCardName() {
        return cardName;
    }

}
