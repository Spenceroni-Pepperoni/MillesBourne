import Cards.*;
public class Computer extends Player {


    public Computer() {
        super();
    }


    public Card takeTurn() {
        if(Game.peekDiscardCard() != null && Game.peekDiscardCard().getCardType().equals("Safety")){
           drawDiscard();
        }else if(Game.peekDiscardCard() != null && Game.peekDiscardCard().getCardType().equals("Remedy")){
            if(Game.peekDiscardCard().getCanPlay()){
                drawDiscard();
            }
        }else{
            drawPile();
        }


        
        int playIndex = -1;
        int max = -1;
        int hazard = -1;


                        for (int i = 0; i < deck.size(); i++) {
                            if (deck.get(i).getCardType().equals("Safety")) {
                                if (getCanPlay(deck.get(i))) {
                                    return discard(i);
                                }
                            }else if(deck.get(i).getCardType().equals("Remedy")){
                                if (getCanPlay(deck.get(i))) {
                                    playIndex = i;
                                }
                            }else if(deck.get(i).getCardType().equals("Mileage")){
                                if(speedLimit()){
                                    if(((MileageCard)deck.get(i)).getMileage()>max && ((MileageCard)deck.get(i)).getMileage()<=50){
                                        max = i;
                                    }
                                }else{
                                    if(((MileageCard)deck.get(i)).getMileage()>max){
                                        max = i;
                                    }
                                }
                            }else if(deck.get(i).getCardType().equals("Hazard")){
                                if (getCanPlay(deck.get(i))) {
                                    hazard = i;
                                }
                            }
                        }
                        if(playIndex>=0){
                            return discard(playIndex);
                        }else if(max>=0){
                            if(((MileageCard)deck.get(max)).getMileage()>50){
                                return discard(max);
                            }else if(hazard>=0){
                                return discard(hazard);
                            }else{
                                return discard(max);
                            }
                        }





        return discard(0);
    }

}
