import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        ClockInterface cio = new ClockInterface();
        cio.setLocationRelativeTo(null);
        cio.setResizable(false);
        cio.setVisible(true);
        cio.setAlwaysOnTop(true);
        cio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - cio.getWidth() - 20;
        int y = (int) rect.getMaxY() - cio.getHeight() - 50;
        cio.setLocation(x, y);
    }
}
