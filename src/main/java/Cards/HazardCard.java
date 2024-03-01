package Cards;

public class HazardCard extends Card{

    public HazardCard(String name){
        super(name);
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
