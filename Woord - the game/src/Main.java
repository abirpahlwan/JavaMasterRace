import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String name = "";
		while(name.length()<3 || name.length()>16)
			name = JOptionPane.showInputDialog(null, "Enter Your Name", "Woord - The Game", JOptionPane.PLAIN_MESSAGE);
		
		MainStage mso = new MainStage();
		MainStage.playerName.setText(name.toUpperCase());
		mso.setSize(1280, 720);
		mso.setLocationRelativeTo(null);
		mso.setResizable(false);
		mso.setVisible(true);
		mso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
