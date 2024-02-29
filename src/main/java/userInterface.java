import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class cardUI{
	BufferedImage image;
	int locX;
	int locY;
	public cardUI(String imageName,int x, int y) {
		try {
			image = ImageIO.read(new File(imageName));
			locX = x;
			locY = y;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, locX, locY, 108, 192, null);
	}
}

class myPanel extends JPanel {
	ArrayList<cardUI> yourDeck= new ArrayList<cardUI>();
	cardUI card = new cardUI("Stop.png",10,10);
	myPanel(){
		for (int i=0;i<7;i++) {
			yourDeck.add(new cardUI("Stop.png",70+120*i,750));
		}
		
	}
    public void paintComponent(Graphics g) {
    	for (int i=0;i<yourDeck.size();i++) {
			yourDeck.get(i).draw(g);
		}
    	
    	g.setColor(Color.RED);
    	g.drawRect(200, 500, 108, 192);
    	g.setColor(Color.GREEN);
    	g.drawRect(400, 500, 108, 192);
    	g.setColor(Color.BLUE);
    	g.drawRect(600, 500, 108, 192);
		
    	for (int i=0;i<yourDeck.size();i++) {
    		card.locX = 850;
    		card.locY = 230+i*-15;
			card.draw(g);
		}
    	
    	g.setFont(new Font("Arial Black", Font.BOLD, 20));
    	g.drawString("Miles",5, 675);
    	g.drawString("You: "+50,5, 700);
    	g.drawString("Computer: "+10,5, 725);
    }
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
