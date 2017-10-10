import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockInterface extends JFrame{
    JPanel topPanel, hourPanel, abusivePanel, minutePanel, footPanel;
    JLabel itsLabel = new JLabel("IT'S");
    JLabel hourLabel = new JLabel(new TimeGenerator().getHour());
    JLabel abusiveLabel = new JLabel("FUCKING");
    JLabel minuteLabel = new JLabel(new TimeGenerator().getMinute());
    JLabel lastLabel = new JLabel("BITCH!");
    Color background = new Color(17, 17, 17);
    int frameWidth, frameHeight;
    boolean secondGlow = true;

    public ClockInterface(){
        super("Abusive Clock");
        setLayout(new GridLayout(5,1));
        setSize(320, 300);
        frameWidth = getWidth();
        frameHeight = frameWidth;


        int fontSize = (getWidth()/8);

        topPanel = new JPanel();
        topPanel.setBackground(background);
        itsLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        itsLabel.setForeground(new Color(3, 89, 156));
        topPanel.add(itsLabel);

        hourPanel = new JPanel();
        hourPanel.setBackground(background);
        hourLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        hourLabel.setForeground(new Color(255, 0, 64));
        hourPanel.add(hourLabel);

        abusivePanel = new JPanel();
        abusivePanel.setBackground(background);
        abusiveLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        abusiveLabel.setForeground(new Color(142, 68, 173));
        abusivePanel.add(abusiveLabel);

        minutePanel = new JPanel();
        minutePanel.setBackground(background);
        minuteLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        minuteLabel.setForeground(new Color(255, 0, 64));
        minutePanel.add(minuteLabel);

        footPanel = new JPanel();
        footPanel.setBackground(background);
        lastLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        lastLabel.setForeground(new Color(243, 156, 18));
        footPanel.add(lastLabel);

        add(topPanel);
        add(hourPanel);
        add(abusivePanel);
        add(minutePanel);
        add(footPanel);

        Thread updater = new Thread(){
            public void run(){
                while(true){
                    try{
                        TimeGenerator tgo = new TimeGenerator();
                        int second = new GregorianCalendar().get(Calendar.SECOND);

                        if(second<1 || second>54) {
                            sleep(100);
                            minuteLabel.setText(tgo.getMinute());
                            hourLabel.setText(tgo.getHour());
                        }
                        else
                            sleep(5000);

                    }
                    catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        };

        Thread blinker = new Thread(){
            public void run(){
                while(true)
                    try{
                        sleep(500);
                        repaint();
                        if(secondGlow)
                            secondGlow = false;
                        else
                            secondGlow = true;
                    }
                    catch(InterruptedException ie){
                        ie.printStackTrace();
                    }

            }
        };

        updater.start();
        blinker.start();

    }

    public void paint(Graphics g){
        super.paint(g);

        if(secondGlow)
            g.setColor(new Color(17, 255,0));
        else
            g.setColor(new Color(17, 63,0));

        g.fillRect(0, 30, 5, (frameHeight/2)-35);
        g.fillRect(0, (frameHeight/2)+5, 5, (frameHeight/2)-35);
        g.fillRect(frameWidth-5, 30, 5, (frameHeight/2)-35);
        g.fillRect(frameWidth-5, (frameHeight/2)+5, 5, (frameHeight/2)-35);

    }

}
