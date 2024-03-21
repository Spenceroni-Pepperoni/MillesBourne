
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

import Cards.*;

import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// a button, you can click on in
class buttonUI{
	int locX;
	int locY;
	int width;
	int height;
	public String text;
	Color color;
	boolean invis;
	boolean clicked = false;
	String panelName = "Default";
	boolean textAboveUI;
	ArrayList<String> textWrapped;
	boolean unclickable;
	Card card;
	
	public buttonUI(int locX,int locY, int width, int height) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
	}
	
	public buttonUI(int locX,int locY, int width, int height, boolean unclickable, String text, Color color) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
		this.unclickable = unclickable;
		this.text = text;
		this.color = color;
	}
	
	public buttonUI(int locX,int locY, int width, int height, Card card) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
		this.card = card;
	}
	
	public buttonUI(int locX,int locY, int width, int height,String panelName) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
		this.panelName = panelName;
	}
	
	public buttonUI(int locX,int locY, int width, int height,String text,Color color,boolean textAboveUI) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
		this.text = text;
		this.color = color;
		this.textAboveUI = textAboveUI;
		createWrappedText();
	}
	
	public buttonUI(int locX,int locY, int width, int height,String text,Color color,boolean textAboveUI,String panelName) {
		this.locX = locX;
		this.locY = locY;
		this.width = width;
		this.height = height;
		this.text = text;
		this.color = color;
		this.textAboveUI = textAboveUI;
		this.panelName = panelName;
		createWrappedText();
	}
	
	public void createWrappedText() {
		if (text.length()>20) {
			textWrapped = new ArrayList<String>();
			String[] words = text.split(" ");
			String line = "";
			for (int i=0;i<words.length;i++) {
				line += words[i] +" ";
				if (i%9==0 && i!=0) {
					textWrapped.add(line);
					line = "";
				}
			}
			textWrapped.add(line);
			for (String s : textWrapped) {
				System.out.println("line: "+s);
			}
		}
	}
	
	public boolean wasClicked(MouseEvent e,String currentPanel) {
		if (panelName == currentPanel && unclickable == false) {
			if (e.getX() > locX && e.getX() < locX+width) {
				if (e.getY() > locY && e.getY() < locY+height) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	public void draw(Graphics g,String currentPanel) {
		if (!invis && panelName == currentPanel ) {
			g.setColor(color);	
			if (clicked) {
				g.fillRect(locX, locY, width, height);
			}
			else {
				g.drawRect(locX, locY, width, height);
			}
			
			if (textWrapped == null) {
				if (textAboveUI) {
					g.drawString(text,locX+(width/16), locY);
				}else {
					g.drawString(text,locX+(width/16), locY+(height/2));
				}
			}else {
				for (int i=0;i<textWrapped.size();i++) {
					g.drawString(textWrapped.get(i),locX+(width/16), locY+(height/2)-(i*20));
				}
			}
			
		}
	}
	
	public void setClicked() {
		clicked = true;
	}
	
	public void setUnclicked() {
		clicked = false;
	}
	
	public void setInvis() {
		invis = true;
	}
	
	public void setVisible() {
		invis = false;
	}
	
	public void setUnclickable() {
		unclickable = true;
	}
}

class cardUI extends buttonUI{
	BufferedImage image;
	int beforeDragX;
	int beforeDragY;
	int deckIndex = 0;
	
	public cardUI(String imageName,int x, int y) {
		super(x,y,108,192);
		try {
			image = ImageIO.read(new File(imageName));
			this.text = imageName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public cardUI(String imageName,int x, int y,int index) {
		super(x,y,108,192);
		try {
			image = ImageIO.read(new File(imageName));
			this.text = imageName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.deckIndex = index;
	}
	
	public cardUI(String imageName,int x, int y,int width,int height,String panelName) {
		super(x,y,width,height,panelName);
		try {
			image = ImageIO.read(new File(imageName));
			this.text = imageName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public cardUI(String imageName,int x, int y,int index, Card card) {
		super(x,y,108, 192, card);
		try {
			image = ImageIO.read(new File(imageName));
			this.text = imageName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.deckIndex = index;
	}
	
	public void draw(Graphics g,String currentPanel) {
		draw(g,currentPanel,false);
	}
	
	public void draw(Graphics g,String currentPanel,boolean selected) {
		if (currentPanel == this.panelName) {
			if (selected) {
				g.setColor(Color.BLUE);
				g.fillRoundRect(locX-5, locY-5, width+10, height+10,13,13);
			}
			g.drawImage(image, locX, locY, width, height, null);
			//System.out.println("drew card");
		}
	}
	
	public void startDrag() {
		beforeDragX = locX;
		beforeDragY = locY;
	}
	
	public void finishDrag() {
		locX = beforeDragX;
		locY = beforeDragY;
	}
}
//------------------------------------------------------------------------
class myPanel extends JPanel implements MouseListener{

	ArrayList<cardUI> yourDeck = new ArrayList<cardUI>();
	ArrayList<buttonUI> cardDropspot = new ArrayList<buttonUI>();
	ArrayList<buttonUI> buttons = new ArrayList<buttonUI>();
	ArrayList<cardUI> playedMiles = new ArrayList<cardUI>();
	ArrayList<cardUI> playedSafeties = new ArrayList<cardUI>();
	ArrayList<cardUI> playedHazards = new ArrayList<cardUI>();
	ArrayList<cardUI> AIplayedMiles = new ArrayList<cardUI>();
	ArrayList<cardUI> AIplayedSafeties = new ArrayList<cardUI>();
	ArrayList<cardUI> AIplayedHazards = new ArrayList<cardUI>();
	ArrayList<cardUI> discards = new ArrayList<cardUI>();
	buttonUI instText = new buttonUI(205, 350, 500, 60, true, "text" , Color.BLACK);
	buttonUI AIplayed = new buttonUI(205, 15, 500, 60, true, "text" , Color.BLUE);
	cardUI drawCard = new cardUI("Back of Card.png",850,125);
	cardUI drawCardPile = new cardUI("Back of Card.png",10,10);
	cardUI draggingCard = null;
	cardUI removedDeckCard = null;
	cardUI backgroundImage = new cardUI("Background.jpg",0,0,1000,1000,"Startscreen");
	cardUI selectedCard = null;
	int draggingDifX = 0;
	int draggingDifY = 0;
	String currentPanel = "Startscreen";
	String rulesText = "Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc Abc";
	Game myGame;
	myPanel(){
		myGame = new Game("PlaceHolder");
		myGame.startGame();
		ArrayList<Card> userDeck =  myGame.getUserDeck();
		for (int i=0;i<userDeck.size();i++) {
			yourDeck.add(new cardUI(userDeck.get(i).getFileName(),70+120*i,750,i, userDeck.get(i)));
			//yourDeck.get(i).deckIndex = i;
		}

		cardDropspot.add(new buttonUI(200, 500, 108, 192, "Hazards",new Color(255, 49, 49),true));
		cardDropspot.add(new buttonUI(400, 500, 108, 192, "Safeties",new Color(143, 79, 255),true));
		cardDropspot.add(new buttonUI(600, 500, 108, 192, "Miles",new Color(58, 181, 255),true));
		cardDropspot.add(new buttonUI(200, 100, 108, 192, "AI Hazards",new Color(255, 49, 49),true));
		cardDropspot.add(new buttonUI(400, 100, 108, 192, "AI Safeties",new Color(143, 79, 255),true));
		cardDropspot.add(new buttonUI(600, 100, 108, 192, "AI Miles",new Color(58, 181, 255),true));
		cardDropspot.add(new buttonUI(40, 740, 900, 220, "YourCards",Color.ORANGE,true));
		cardDropspot.get(cardDropspot.size()-1).setInvis();
		cardDropspot.add(new buttonUI(20, 200, 108, 192, "Discard",Color.BLACK,true));
		instText.setInvis();
		AIplayed.setInvis();
		
		buttons.add(new buttonUI(830, 480, 100, 60, "Save",Color.BLUE,false));
		buttons.add(new buttonUI(830, 550, 100, 60, "Load",Color.BLUE,false));
		buttons.add(new buttonUI(830, 620, 100, 60, "Rules",Color.BLUE,false));
		
		buttons.add(new buttonUI(800, 560, 100, 60, "Load",Color.BLUE,false,"Startscreen"));
		buttons.add(new buttonUI(800, 480, 100, 60, "Start",Color.BLUE,false,"Startscreen"));
		
		buttons.add(new buttonUI(300, 100, 600, 370, rulesText,Color.BLUE,false,"Rulesscreen"));
		buttons.get(buttons.size()-1).setUnclickable();
		buttons.add(new buttonUI(800, 480, 100, 60, "Resume",Color.BLUE,false,"Rulesscreen"));
		
		addMouseListener(this);
		 this.addMouseMotionListener(new MouseMotionAdapter() {
	            @Override
	            public void mouseDragged(MouseEvent e) {
	            	//System.out.println("mouse dragged");
	                if (draggingCard != null) {
	                	//System.out.println("dragging card: "+draggingCard.text);
	                	draggingCard.locX = e.getX()-draggingDifX;
	                	draggingCard.locY = e.getY()-draggingDifY;
	                }
	                repaint();
	            }
	        });
		
	}
    public void paintComponent(Graphics g) {
    	g.setColor(new Color(255, 179, 71));
    	//g.setColor(new Color(156,175,136));
    	g.fillRect(0, 0, 1000, 1000);
    	
    	g.setColor(Color.BLUE);
    	g.setFont(new Font("Arial Black", Font.BOLD, 20));
    	backgroundImage.draw(g, currentPanel);
    	new buttonUI(5, 600, 100, 40, "Miles",Color.BLUE,false).draw(g, currentPanel);
    	new buttonUI(5, 650, 100, 40, "You:"+myGame.getUserMileage(),Color.BLUE,false).draw(g, currentPanel);
    	new buttonUI(5, 700, 100, 40, "AI:"+myGame.getComputerMileage(),Color.BLUE,false).draw(g, currentPanel);

    	instText.draw(g, currentPanel);
    	AIplayed.draw(g, currentPanel);
    	
    	for (int i=0;i<yourDeck.size();i++) {
    		//System.out.println("drawing " + yourDeck.get(i).card.getCardName());
			yourDeck.get(i).draw(g,currentPanel);
		}
    	for (int i=0;i<cardDropspot.size();i++) {
    		cardDropspot.get(i).draw(g,currentPanel);
    	}
    	for (int i=0;i<buttons.size();i++) {
    		buttons.get(i).draw(g,currentPanel);
    	}
    	
    	for (int i = 0; i < playedMiles.size(); i++) {
    		playedMiles.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < playedHazards.size(); i++) {
    		playedHazards.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < playedSafeties.size(); i++) {
    		playedSafeties.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < AIplayedMiles.size(); i++) {
    		AIplayedMiles.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < AIplayedHazards.size(); i++) {
    		AIplayedHazards.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < AIplayedSafeties.size(); i++) {
    		AIplayedSafeties.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i = 0; i < discards.size(); i++) {
    		discards.get(i).draw(g, currentPanel);
    	}
    	
    	for (int i=0;i<6;i++) {
    		drawCardPile.locX = 850;
    		drawCardPile.locY = 230+i*-15;
    		drawCardPile.draw(g,currentPanel);
		}
    	
    	if (selectedCard != null) {
    		selectedCard.draw(g, currentPanel,true);
    	}
    	drawCard.draw(g,currentPanel);
    }
        
    public void redraw() {
    	Graphics g = getGraphics();
    	paintComponent(g);
    }
    
    public void setDraggingCard(cardUI card,MouseEvent e) {
    	card.startDrag();
		this.draggingCard = card;
		draggingDifX = (e.getX()-draggingCard.locX);
		draggingDifY = (e.getY()-draggingCard.locY);
    }
    
    public void mousePressed(MouseEvent e) {
    	if (e.getButton() == MouseEvent.BUTTON1) {
	    	//System.out.println("mouse pressed");
	    	// add buffer image to stop flickering
	    	for (int i=0;i<buttons.size();i++) {
	    		if (buttons.get(i).wasClicked(e,currentPanel)) {
	    			buttons.get(i).setClicked();
	    			redraw();
	    		}
	    	}
	    	for (int i=0;i<yourDeck.size();i++) {
	    		if (yourDeck.get(i).wasClicked(e,currentPanel)){
	    			selectedCard = yourDeck.get(i);
	    			setDraggingCard(yourDeck.get(i), e);
	    			//System.out.println("selected card: "+ i + " " + yourDeck.get(i).card.getCardName());
	    			redraw();
	    		}
			}
	    	if (drawCard.wasClicked(e,currentPanel)){
	    		setDraggingCard(drawCard, e);
	    		redraw();
	    	}
    	}
    	
    }
    
    public void moveCard(int dropSpot) {
    	draggingCard.setUnclickable();
    	draggingCard.locX = cardDropspot.get(dropSpot).locX;
		draggingCard.locY = cardDropspot.get(dropSpot).locY;
		removedDeckCard = draggingCard;
    }
    
    public void setScreen(String panelName) {
    	currentPanel = panelName;
    	redraw();
    }
    
    public void mouseReleased(MouseEvent e) {
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setUnclicked();
				if (buttons.get(i).wasClicked(e, currentPanel)) {
					switch (buttons.get(i).text) {
						case "Save": {
							break;
						}
						case "Load": {

							break;
						}
						case "Rules": {
							setScreen("Rulesscreen");
							break;
						}
						case "Start": {

							setScreen("Default");
							break;
						}
						case "Resume": {
							setScreen("Default");
							break;
						}
					}

				}
				redraw();
			}
			if (draggingCard != null) {
				draggingCard.finishDrag();
				for (int i = 0; i < cardDropspot.size(); i++) {
					if (cardDropspot.get(i).wasClicked(e, currentPanel)) {
						Card compCard = null;
						switch (cardDropspot.get(i).text) {
							case "AI Hazards": {
								if (draggingCard.card.getCardType().equals("Hazard") && yourDeck.size() == 7) {
									compCard = myGame.playCard(draggingCard.card);
									AIplayed.text = "AI played: " + compCard.getCardName();
									AIplayed.setVisible();
									moveCard(i);
									yourDeck.remove(draggingCard.deckIndex);
									AIplayedHazards.add(draggingCard);
									instText.setInvis();
								} else if (!draggingCard.card.getCardType().equals("Hazard") && yourDeck.size() == 7) {
									instText.text = "Wrong pile!";
									instText.setVisible();
								} else {
									instText.text = "You must draw a card first!";
									instText.setVisible();
								}
								break;
							}
							case "Hazards": {
								if (draggingCard.card.getCardType().equals("Remedy") && yourDeck.size() == 7) {
									compCard = myGame.playCard(draggingCard.card);
									AIplayed.text = "AI played: " + compCard.getCardName();
									AIplayed.setVisible();
									moveCard(i);
									yourDeck.remove(draggingCard.deckIndex);
									playedHazards.add(draggingCard);
									instText.setInvis();
								} else if (!draggingCard.card.getCardType().equals("Remedy") && yourDeck.size() == 7) {
									instText.text = "Wrong pile!";
									instText.setVisible();
								} else {
									instText.text = "You must draw a card first!";
									instText.setVisible();
								}
								break;
							}
							case "Safeties": {
								if (draggingCard.card.getCardType().equals("Safety") && yourDeck.size() == 7) {
									compCard = myGame.playCard(draggingCard.card);
									AIplayed.text = "AI played: " + compCard.getCardName();
									AIplayed.setVisible();
									moveCard(i);
									yourDeck.remove(draggingCard.deckIndex);
									playedSafeties.add(draggingCard);
									instText.setInvis();
								} else if (!draggingCard.card.getCardType().equals("Safety") && yourDeck.size() == 7) {
									instText.text = "Wrong pile!";
									instText.setVisible();
								} else {
									instText.text = "You must draw a card first!";
									instText.setVisible();
								}
								break;
							}
							case "Miles": {
								if (draggingCard.card.getCardType().equals("Mileage") && yourDeck.size() == 7) {
									compCard = myGame.playCard(draggingCard.card);
									AIplayed.text = "AI played: " + compCard.getCardName();
									AIplayed.setVisible();
									//System.out.println(myGame.getUserMileage());
									moveCard(i);
									yourDeck.remove(draggingCard.deckIndex);
									playedMiles.add(draggingCard);
									instText.setInvis();
								} else if (!draggingCard.card.getCardType().equals("Mileage") && yourDeck.size() == 7) {
									instText.text = "Wrong pile!";
									instText.setVisible();
								} else {
									instText.text = "You must draw a card first!";
									instText.setVisible();
								}
//	    					c.playCard();
								break;
							}
							case "Discard": {
								if (yourDeck.size() == 7) {
									moveCard(i);
									compCard = myGame.compTakesTurn();
									AIplayed.text = "AI played: " + compCard.getCardName();
									AIplayed.setVisible();
									yourDeck.remove(draggingCard.deckIndex);
									discards.add(draggingCard);
									instText.setInvis();
								} else {
									instText.text = "You must draw a card first!";
									instText.setVisible();
								}
								break;
							}
							case "YourCards": {
								if (draggingCard.equals(drawCard) && yourDeck.size() < 7) {
									instText.setInvis();
									AIplayed.setInvis();
									//removedDeckCard.locX = removedDeckCard.beforeDragX;
									//removedDeckCard.locY = removedDeckCard.beforeDragY;
									//System.out.println("removed card deck index: " + removedDeckCard.deckIndex);
									Card newCard = myGame.userDrawPile();
									yourDeck.add(new cardUI(newCard.getFileName(), removedDeckCard.beforeDragX, removedDeckCard.beforeDragY, removedDeckCard.deckIndex, newCard));
									// user dragged a new card into there deck Back of Card.png
									//yourDeck.set(removedCardIndex,new cardUI("Stop.png",70+120*removedCardIndex,750));
								} else {
									instText.text = "You must play/discard a card first!";
									instText.setVisible();
								}
								break;
							}
						}
						if (compCard != null) {
							switch (compCard.getCardType()) {
								case "Hazard": {
									playedHazards.add(new cardUI(compCard.getFileName(), 200, 500, 0, compCard));
									break;
								}
								case "Remedy": {
									AIplayedHazards.add(new cardUI(compCard.getFileName(), 200, 100, 0, compCard));
									break;
								}
								case "Safety": {
									AIplayedSafeties.add(new cardUI(compCard.getFileName(), 400, 100, 0, compCard));
									break;
								}
								case "Mileage": {
									AIplayedMiles.add(new cardUI(compCard.getFileName(), 600, 100, 0, compCard));
									break;
								}
							}
						}
						//redraws user's deck in order, moves all empty spaces to end
						for (int j = 0; j < yourDeck.size(); j++) {
				    		yourDeck.get(j).locX = 70 + 120 * j;
				    		yourDeck.get(j).deckIndex = j;
				    	}
					}
				}
				draggingCard = null;
				//redraw();
			}

    	repaint();
    	redraw();
    	/*
    	System.out.println("mouse released\n");
    	System.out.println("yourDeck (deck shown in ui):");
    	System.out.println("length " + yourDeck.size());
    	for (cardUI i : yourDeck) {
    		System.out.println(i.card.getCardName());
    	}
    	System.out.println("\nuserDeck (deck stored in game):");
    	for (Card c : myGame.getUserDeck()) {
    		System.out.println(c.getCardName());
    	}
    	*/
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}


public class userInterface {
    userInterface() {
        JFrame frame = new JFrame();
        myPanel panel = new myPanel();
        frame.getContentPane().add(panel);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
