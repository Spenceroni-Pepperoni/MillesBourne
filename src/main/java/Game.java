import Cards.*;
import java.util.*;

public class Game {
    private ArrayList<Card> pile;
    private ArrayList<Card> discard;
    private Player user;
    private Player computer;


    public Game(){
        user = new HumanPlayer(null);   //placeholder
        computer = new Computer();
    }

    public void startGame(){
        user.setMileage(0);
        computer.setMileage(0);
        for(int i = 0; i<3;i++){
            pile.add((int)(Math.random()*pile.size()),new HazardCard("Accident"));
        }
        for(int i = 0; i<3;i++){
            pile.add((int)(Math.random()*pile.size()),new HazardCard("Flat Tire"));
        }
        for(int i = 0; i<3;i++){
            pile.add((int)(Math.random()*pile.size()),new HazardCard("Out of Gas"));
        }
        for(int i = 0; i<5;i++){
            pile.add((int)(Math.random()*pile.size()),new HazardCard("Stop"));
        }
        for(int i = 0; i<4;i++){
            pile.add((int)(Math.random()*pile.size()),new HazardCard("Speed Limit"));
        }
        for(int i = 0; i<6;i++){
            pile.add((int)(Math.random()*pile.size()),new RemedyCard("Repairs"));
        }
        for(int i = 0; i<6;i++){
            pile.add((int)(Math.random()*pile.size()),new RemedyCard("Gas"));
        }
        for(int i = 0; i<6;i++){
            pile.add((int)(Math.random()*pile.size()),new RemedyCard("Spare Tire"));
        }
        for(int i = 0; i<6;i++){
            pile.add((int)(Math.random()*pile.size()),new RemedyCard("Drive"));
        }
        for(int i = 0; i<6;i++){
            pile.add((int)(Math.random()*pile.size()),new RemedyCard("End of Speed Limit"));
        }
        pile.add((int)(Math.random()*pile.size()),new SafetyCard("Driving Ace"));
        pile.add((int)(Math.random()*pile.size()),new SafetyCard("Extra Tank"));
        pile.add((int)(Math.random()*pile.size()),new SafetyCard("Puncture Proof"));
        pile.add((int)(Math.random()*pile.size()),new SafetyCard("Emergency Vehicle"));
        for(int i = 0; i<10;i++){
            pile.add((int)(Math.random()*pile.size()),new MileageCard("Miles", 25));
        }
        for(int i = 0; i<10;i++){
            pile.add((int)(Math.random()*pile.size()),new MileageCard("Miles", 50));
        }
        for(int i = 0; i<10;i++){
            pile.add((int)(Math.random()*pile.size()),new MileageCard("Miles", 75));
        }
        for(int i = 0; i<12;i++){
            pile.add((int)(Math.random()*pile.size()),new MileageCard("Miles", 100));
        }
        for(int i = 0; i<4;i++){
            pile.add((int)(Math.random()*pile.size()),new MileageCard("Miles", 200));
        }

    }

}
