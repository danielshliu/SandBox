import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Main extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);//you should always call the super-method first

        //Mauritius
        g.setColor(new Color(235,36,54));
        g.fillRect(0, 0,320, 54);

        g.setColor(new Color(53,26,109));
        g.fillRect(0,54,320, 54);

        g.setColor(new Color(255,214,0));
        g.fillRect(0,109,320,54);

        g.setColor(new Color(0,166,80));
        g.fillRect(0,163,320,54  );

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Mauritius",90,250);

        //Bangladesh
        g.setColor(new Color(0,106,78));
        g.fillRect(360,0,320,216);
        g.setColor(new Color(244,42,65));
        g.fillOval(432,54,128,128);

        //This is the end of where your drawing happens.
    }

    public static void main(String[] args) throws InterruptedException {

        Main expo = new Main();
        JFrame f = new JFrame();

        //This part is used if you need to input anything.
        Scanner sc = new Scanner(System.in);


        //allows us to see the frame
        f.setVisible(true);

        //These are the dimensions of your window.
        f.setSize(1000, 1000);

        //Program ends when x is pressed.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(expo);


        while (true) {
            f.repaint();

        }
    }


    //...and ending here, and place that INSIDE your public class
}
