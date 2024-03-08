import Cards.*;
public class Computer extends Player {


    public Computer() {
        super();
    }


    public Card takeTurn() {
        if(Game.getDiscardCard().getCardType().equals("Safety")){
           drawDiscard();
        }else if(Game.getDiscardCard().getCardType().equals("Remedy")){
            if(Game.getDiscardCard().getCanPlay()){
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
                                if (deck.get(i).getCanPlay()) {
                                    return deck.get(i);
                                }
                            }else if(deck.get(i).getCardType().equals("Remedy")){
                                if (deck.get(i).getCanPlay()) {
                                    playIndex = i;
                                }
                            }else if(deck.get(i).getCardType().equals("Mileage")){
                                if(speedLimit()){
                                    if(deck.get(i).getMileage()>max && deck.get(i).getMileage()<=50){
                                        max = i;
                                    }
                                }else{
                                    if(deck.get(i).getMileage()>max){
                                        max = i;
                                    }
                                }
                            }else if(deck.get(i).getCardType().equals("Hazard")){
                                if (deck.get(i).getCanPlay()) {
                                    hazard = i;
                                }
                            }
                        }
                        if(playIndex>=0){
                            return discard(playIndex);
                        }else if(max>=0){
                            if(deck.get(max).getMileage()>50){
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