import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainStage extends JFrame{
	WordPanel charPan;
	static WordPanel[][] imagePan = new WordPanel[10][10];
	JPanel gridPan, buttonPan, scorePan;	
	static String randomString="", wordString="";
	static int score = 0;
	static JLabel playerName;
	static JLabel scoreLabel;
	static JLabel wordLabel;
	JButton colorButton = new JButton(new ImageIcon("icon/colorButton.png"));
	JButton helpButton = new JButton(new ImageIcon("icon/helpButton.png"));
	JButton infoButton = new JButton(new ImageIcon("icon/infoButton.png"));
	Font lcdFont;
	
	public MainStage(){
		super("Woord!");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		
		buttonPan = new JPanel();
		buttonPan.setLayout(new GridLayout());
		
		colorButton.setToolTipText("Change Color");
		helpButton.setToolTipText("See Help");
		infoButton.setToolTipText("About");
		
		ButtonListener lco = new ButtonListener();
		colorButton.addActionListener(lco);
		helpButton.addActionListener(lco);
		infoButton.addActionListener(lco);
		
		buttonPan.add(colorButton);	
		buttonPan.add(helpButton);
		buttonPan.add(infoButton);
				
		charPan = new WordPanel(WordPanel.randomChar);
		charPan.setLayout(new FlowLayout());
		
		gridPan = new JPanel();
		gridPan.setLayout(new GridLayout(10, 10));
		gridPan.setPreferredSize(new Dimension(500, 500));
				
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				imagePan[i][j] = new WordPanel();
				gridPan.add(imagePan[i][j]);
			}
		}
		
		scorePan = new JPanel();
		scorePan.setLayout(new GridLayout(3,1));
		
		playerName = new JLabel();
		playerName.setFont(new Font("Arial", Font.BOLD, 40));		
		
		try {
			lcdFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/LCD.ttf"));
			lcdFont = lcdFont.deriveFont(Font.PLAIN, 65);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(lcdFont);
		}
		catch(IOException|FontFormatException e) {
		     //Handle exception
		}
		
		scoreLabel = new JLabel("000000");
		scoreLabel.setFont(lcdFont);
		
		wordLabel = new JLabel();
		wordLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		scorePan.add(playerName);
		scorePan.add(scoreLabel);
		scorePan.add(wordLabel);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(scorePan, gbc);
		/*
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(charPan, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(gridPan, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(buttonPan, gbc);*/

	}
	
	public static void updateScore(int w){
		score += Integer.valueOf((int)(Math.pow(2, w)));
		scoreLabel.setText(String.format("%06d", score));
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(imagePan[i][j].isIncluded == true){
					imagePan[i][j].s="";
					imagePan[i][j].setImageLabel("");
				}
			}
		}
	}
	
	public static void tryAgain(){
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				imagePan[i][j].isIncluded = false;
			}
		}
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == colorButton){
				if(WordPanel.stringColor == "blue")
					WordPanel.stringColor = "black";
				else
					WordPanel.stringColor = "blue";
				
				for(int i = 0; i < 10; i++){
					for(int j = 0; j < 10; j++){
						imagePan[i][j].changeColor();
					}
				}					
			}
			
			if(e.getSource() == helpButton){
				String helpText = "1. Click on a blank box to place the letter on it.\n"
								+ "2. Try and make words.\n"
								+ "3. Drag through the word to score.\n"
								+ "4. Enjoy!";
				
				JOptionPane.showMessageDialog(null, helpText , "Woord Help!", JOptionPane.PLAIN_MESSAGE);
			}
			
			if(e.getSource() == infoButton){
				String aboutText = "Woord - the Game\n\n"
								 + "Developers\n"
								 + "Pahlwan Rabiul Islam\n"
								 + "Rifat Ara Chowdhury";
				
				JOptionPane.showMessageDialog(null, aboutText, "About Woord!", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
