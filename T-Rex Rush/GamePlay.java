
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class GamePlay extends JFrame implements Runnable{
	Dug dugo = new Dug();
	static int dugLocationX = 0;
	static int dugLocationY = 400;
	Thread moveDino;
	
	public GamePlay(){
		super("Dug Rush");
		add(dugo);
		
		addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//dugo.setLocation(dugLocationX, -(1/15)+15-400);
					if(e.getClickCount()>1)
						doubleJump();
					else
						singleJump();
				}
			}
		);
		
		moveDino = new Thread();
		moveDino.start();
	}
	
	private void singleJump(){
		dugLocationY = dugLocationY-150;
		dugo.setLocation(dugLocationX, dugLocationY-400);
	}
	
	private void doubleJump(){
		dugLocationY = dugLocationY+300;
		dugo.setLocation(dugLocationX, dugLocationY-400);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
