import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Main extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);//you should always call the super-method first
        /*
                All the color are in RGB
                All of the dimensions were written from the calculations sheet.
                I basically just took the dimensions of the flag and times it by 10.
                Each axis for each flag are just increments of it self like if one of the flag
                started at x-300 y-0 and its block shape is 40x40 then the block next to it would just plus
                'x' by 40 and the one block below it would plus 'y' by 40.

        */
        //Mauritius
        g.setColor(new Color(235,36,54)); 
        g.fillRect(0, 0,324, 54);

        g.setColor(new Color(53,26,109));
        g.fillRect(0,54,324, 54);

        g.setColor(new Color(255,214,0));
        g.fillRect(0,109,324,54);

        g.setColor(new Color(0,166,80));
        g.fillRect(0,163,324,54);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Mauritius",90,250);

        //Bangladesh
        g.setColor(new Color(0,106,78));
        g.fillRect(360,0,500,300);
        g.setColor(new Color(244,42,65));
        g.fillOval(464,50,200,200);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Bangladesh",500,350);

        //Botswana
        g.setColor(new Color(171,202,237));
        g.fillRect(900,0,360,90);
        g.setColor(new Color(255,255,255));
        g.fillRect(900,90,360,10);
        g.setColor(new Color(0,0,0));
        g.fillRect(900,100,360,40);
        g.setColor(new Color(255,255,255));
        g.fillRect(900,140,360,10);
        g.setColor(new Color(171,202,247));
        g.fillRect(900,150,360,90);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Botswana",950,300);

        //Benin
        g.setColor(new Color(0,135,81));
        g.fillRect(0,370,120,200);
        g.setColor(new Color(252,209,22));
        g.fillRect(120,370,180,100);
        g.setColor(new Color(232,17,45));
        g.fillRect(120,470,180,100);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Benin",70,620);

        //Tonga
        g.setColor(new Color(255,255,255));
        g.fillRect(360,370,120,10);
        g.setColor(new Color(255,255,255));
        g.fillRect(450,370,30,80);
        g.setColor(new Color(255,255,255));
        g.fillRect(360,380,50,20);
        g.setColor(new Color(193,0,0));
        g.fillRect(410,380,20,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(430,380,20,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(360,400,30,20);

        g.setColor(new Color(193,0,0));
        g.fillRect(390,400,60,20);

        g.setColor(new Color(255,255,255));
        g.fillRect(360,420,50,20);
        g.setColor(new Color(193,0,0));
        g.fillRect(410,420,20,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(430,420,20,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(360,440,120,10);
        g.setColor(new Color(193,0,0));
        g.fillRect(360,450,320,80);
        g.setColor(new Color(193,0,0));
        g.fillRect(480,370,200,80);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Tonga",430,580);

        //Greece
        g.setColor(new Color(0,20,137));
        g.fillRect(700,370,40,40);
        g.setColor(new Color(255,255,255));
        g.fillRect(740,370,20,40);
        g.setColor(new Color(0,20,137));
        g.fillRect(760,370,40,40);
        g.setColor(new Color(0,20,137));
        g.fillRect(800,370,170,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(800,390,170,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(700,410,100,20);
        g.setColor(new Color(0,20,137));
        g.fillRect(800,410,170,20);
        g.setColor(new Color(0,20,137));
        g.fillRect(700,430,40,40);
        g.setColor(new Color(255,255,255));
        g.fillRect(740,430,20,40);
        g.setColor(new Color(0,20,137));
        g.fillRect(760,430,40,40);
        g.setColor(new Color(255,255,255));
        g.fillRect(800,430,170,20);
        g.setColor(new Color(0,20,137));
        g.fillRect(800,450,170,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(700,470,270,20);
        g.setColor(new Color(0,20,137));
        g.fillRect(700,490,270,20);
        g.setColor(new Color(255,255,255));
        g.fillRect(700,510,270,20);
        g.setColor(new Color(0,20,137));
        g.fillRect(700,530,270,20);
        
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Greece",750,580);
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
        f.setSize(1500, 1000);

        //Program ends when x is pressed.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(expo);


        while (true) {
            f.repaint();

        }
    }


    //...and ending here, and place that INSIDE your public class
}
