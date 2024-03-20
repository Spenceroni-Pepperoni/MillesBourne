import java.util.*;
import Cards.*;

public abstract class Player {

	protected ArrayList<Card> deck;
	protected int mileage;
	private boolean isTurn;
	protected ArrayList<Card> hazards;
	protected ArrayList<Card> safeties;
	private boolean started;

	public Player(){
		deck = new ArrayList<Card>();
		mileage = 0;
		hazards = new ArrayList<Card>();
		safeties = new ArrayList<Card>();
		isTurn = false;

	}

	public void drawPile() {
		deck.add(Game.getPileCard()); //method isn't in decomp but might be needed
	}
	
	public void drawDiscard() {
		deck.add(Game.getDiscardCard()); //same here
	}

	public abstract Card takeTurn();
	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int miles){
		mileage = miles;
	}

	public void receiveHazard(Card card) {
		hazards.add(card);
	}

	public void removeHazard(RemedyCard card){
		if(card.getCardName().equals("Spare Tire")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Flat Tire")){
					hazards.remove(i);
					return;
				}
			}
		}else if(card.getCardName().equals("Drive")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Stop")){
					hazards.remove(i);
					return;
				}
			}
		}else if(card.getCardName().equals("Gasoline")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Out of Gas")){
					hazards.remove(i);
					return;
				}
			}
		}else if(card.getCardName().equals("End of SpeedLimit")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Speed Limit")){
					hazards.remove(i);
					return;
				}
			}
		}else if(card.getCardName().equals("Repair")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Accident")){
					hazards.remove(i);
					return;
				}
			}
		}


	}

	public void receiveSafety(Card card){
		safeties.add(card);
	}





	public Card discard(int index) {
		Card temp = deck.get(index);
		deck.remove(index);
		return temp;
	}

	public boolean speedLimit() {
		for(Card hazard : hazards) {
			if(hazard.getCardName().equals("Speed Limit")) {
				return true;
			}
		}
		return false;
	}

	public boolean hasHazard() {
		for(Card hazard : hazards) {
			if(!hazard.getCardName().equals("speedLimit")) {
				return true;
			}
		}
		return false;
	}

	public boolean getCanPlay(Card card){
		if(card.getCardType().equals("Mileage")){
			if(hasHazard()){
				return false;
			}else{
				if(speedLimit()){
					if(((MileageCard) card).getMileage()<= 50){
						return true;
					}else{
						return false;
					}
				}
			}
		}else if(card.getCardType().equals("Remedy")){
			return checkRemedy((RemedyCard)card);
		}else{
			return true;
		}
		return true;
	}

	public void setTurn(boolean turn){
		isTurn = turn;
	}
	
	public boolean getTurn() {
		return isTurn;
	}


	private boolean checkRemedy(RemedyCard card){
		if(hazards.size() ==0){
			return false;
		}
		if(card.getCardName().equals("Spare Tire")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Flat Tire")){
					return true;
				}
			}
		}else if(card.getCardName().equals("Drive")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Stop")){
					return true;
				}
			}
		}else if(card.getCardName().equals("Gasoline")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Out of Gas")){
					return true;
				}
			}
		}else if(card.getCardName().equals("End of SpeedLimit")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Speed Limit")){
					return true;
				}
			}
		}else if(card.getCardName().equals("Repair")){
			for(int i =0; i<hazards.size(); i++){
				if(hazards.get(i).getCardName().equals("Accident")){
					return true;
				}
			}
		}

		return false;

	}

}
