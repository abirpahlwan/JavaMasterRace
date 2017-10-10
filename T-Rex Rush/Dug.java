import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Dug extends JPanel implements Runnable{
	BufferedImage dinoRight, dinoLeft, dinoOver;
	int dinoX = GamePlay.dugLocationX;
	int dinoY = GamePlay.dugLocationY;
	int obstacleX = 700;
	int obstacleY = 320;
	int leg = 0;
	Thread runDino;
	
	public Dug(){
		try{
			dinoRight = ImageIO.read(new File("right.png"));
			dinoLeft = ImageIO.read(new File("left.png"));
			dinoOver = ImageIO.read(new File("over.png"));
	       }catch (IOException ex){
	    	   
	       }
		runDino = new Thread(this);
		runDino.start();
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(3);
				/*if(dinoX>obstacleX){
					break;
				}*/
				dinoX++;
				leg = (leg<40 ? leg+=1 : 0);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void go(){
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(255,0,0));
		int[] dinoXP = {dinoX+0, dinoX+40, dinoX+40, dinoX+60, dinoX+60, dinoX+70, dinoX+70, dinoX+80, dinoX+80, dinoX+90, dinoX+90, dinoX+150, dinoX+150, dinoX+130, dinoX+130, dinoX+110, dinoX+110, dinoX+120, dinoX+120, dinoX+130, dinoX+130, dinoX+140, dinoX+140, dinoX+130, dinoX+130, dinoX+120, dinoX+120, /*dinoX+100, dinoX+100, dinoX+110, dinoX+110, dinoX+70, dinoX+70,*/ dinoX+30, dinoX+30, dinoX+20, dinoX+20, dinoX+0};
		int[] dinoYP = {dinoY+130, dinoY+130, dinoY+160, dinoY+160, dinoY+150, dinoY+150, dinoY+120, dinoY+120, dinoY+100, dinoY+100, dinoY+10, dinoY+10, dinoY+40, dinoY+40, dinoY+50, dinoY+50, dinoY+90, dinoY+90, dinoY+110, dinoY+110, dinoY+130, dinoY+130, dinoY+180, dinoY+180, dinoY+190, dinoY+190, dinoY+200, /*dinoY+200, dinoY+220, dinoY+220, dinoY+230, dinoY+230, dinoY+200,*/ dinoY+200, dinoY+190, dinoY+190, dinoY+140, dinoY+140};
		
		int[] legXP = {dinoX+110-leg, dinoX+110-leg, dinoX+120-leg, dinoX+120-leg, dinoX+80-leg, dinoX+80-leg};
		int[] legYP = {dinoY+200, dinoY+220, dinoY+220, dinoY+230, dinoY+230, dinoY+200};
		
		//The Dug
		{
			if(dinoX>this.getWidth())
				dinoX = 0;
			if(dinoY>400)
				dinoY = 0;
			
			g.setColor(new Color(193, 16, 86));
			g.fillPolygon(dinoXP, dinoYP, 32);
			g.fillPolygon(legXP, legYP, 6);

			g.setColor(new Color(0, 174, 239));
			g.fillRect(dinoX+90, dinoY+60, 20, 10);
			
			g.setColor(new Color(50, 50, 50));
			g.fillRect(dinoX+60, dinoY+140, 10, 10);
			g.fillRect(dinoX+80, dinoY+130, 10, 10);
			g.fillRect(dinoX+90, dinoY+110, 10, 10);
			g.fillRect(dinoX+90, dinoY+150, 10, 10);
			g.fillRect(dinoX+100, dinoY+0, 10, 10);
		}
	}
}
