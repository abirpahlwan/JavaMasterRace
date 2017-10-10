import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		GamePlay gpo = new GamePlay();
		gpo.setSize(1280, 720);
		gpo.setLocationRelativeTo(null);
		gpo.setResizable(false);
		gpo.setVisible(true);
		gpo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
