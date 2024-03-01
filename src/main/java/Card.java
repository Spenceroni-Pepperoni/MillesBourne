public abstract class Card {

    private String cardName;

    /**
     * Constructor for Card Class
     * @param name name of the Card
     */
    Card(String name){
        this.cardName = name;
    }

    abstract boolean getCanPlay();

    abstract String getCardType();

    public String getCardName() {
        return cardName;
    }

}
