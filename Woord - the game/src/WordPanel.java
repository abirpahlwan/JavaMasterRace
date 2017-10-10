import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel{
	static String randomChar;
	static JLabel randomLabel;
	String s = "";
	protected static String word;
	static Random random = new Random();
	public static String stringColor = "blue";
	JLabel imageLabel = new JLabel(new ImageIcon("icon/" + s.toUpperCase() + "." + stringColor + ".png"));
	static WordCollection wco = new WordCollection();
	boolean isIncluded = false;
	
	public WordPanel(){
		setImageLabel(s);
		add(imageLabel);
		setSize(48,48);
		
		ListenerClass lco = new ListenerClass();
		addMouseListener(lco);
		addMouseMotionListener(lco);
	}
	
	public WordPanel(String args){
		randomLabel = new JLabel(new ImageIcon("icon/" + newRandomChar().toUpperCase() + "." + stringColor + ".png"));
		add(randomLabel);
		setSize(48, 48);
		
	}
	
	public boolean isEmpty(){
		if(s.equals(""))
			return true;
		else
			return false;
	}
	
	public boolean isInitiated(){
		if(word != null)
			return true;
		else
			return false;
	}
	
	public void changeColor(){
		randomLabel.setIcon(new ImageIcon("icon/" + randomChar.toUpperCase() + "." + stringColor + ".png"));			
		imageLabel.setIcon(new ImageIcon("icon/" + s.toUpperCase() + "." + stringColor + ".png"));
	}
	
	public void setImageLabel(String s){
		imageLabel.setIcon(new ImageIcon("icon/" + s.toUpperCase() + "." + stringColor + ".png"));
	}
	
	public static String newRandomChar(){
		char c = (char)(65+random.nextInt(26));
		randomChar = String.valueOf(c);
		return randomChar;
	}
	
	private class ListenerClass implements MouseListener, MouseMotionListener{

		//MouseMotionListener methods
		public void mouseDragged(MouseEvent event) {
			if(!isInitiated()){
				word = s;
				isIncluded = true;
			}
		}

		public void mouseMoved(MouseEvent event) {
			
		}

		//MouseListener methods
		public void mouseClicked(MouseEvent event) {
			if(isEmpty()){
				s = randomChar;
				setImageLabel(s);
				randomLabel.setIcon(new ImageIcon("icon/" + newRandomChar().toUpperCase() + "." + stringColor + ".png"));
				MainStage.wordLabel.setText("");
			}
		}

		public void mouseEntered(MouseEvent event) {
			if(isInitiated() && word.length()<=10){
				if(isEmpty()){
					mouseReleased(event);
				}
				else{
					word = word+s;
					isIncluded = true;
					MainStage.wordLabel.setText(word);
				}
			}
		}

		public void mouseExited(MouseEvent event) {
			
		}

		public void mousePressed(MouseEvent event) {
			mouseClicked(event);
		}

		public void mouseReleased(MouseEvent event) {
			if(isInitiated()){				
				if(wco.searchWord(word.toLowerCase())){
					MainStage.wordLabel.setText("Word Found");
					MainStage.updateScore(word.length());
				}
				else{
					MainStage.wordLabel.setText("Word Not Found");
					MainStage.tryAgain();
				}
			}
			
			word = null;
		}
		
	}

}
