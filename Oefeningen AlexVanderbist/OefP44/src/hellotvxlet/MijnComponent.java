/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    
    Image spaceship;
    int sx = 0;

    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); // afmetingen van de component
        spaceship = this.getToolkit().getImage("spaceship.png");
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(spaceship, 1);
        
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void setSpaceship(int x) {
        sx = x;
        this.repaint();
    }
    
    public void paint(Graphics g)
    {
        
        //g.drawLine(0,0,100,100); // x1,y1, x2,y2
        //g.drawLine(100,0,0,100);
        //g.setColor(Color.RED);
        //g.fillRoundRect(0, 0, 100, 100, 15, 15);
        //g.setColor(new DVBColor(0,0,255,179));
        //g.drawString("Tekst", 20, 20);
        g.drawImage(spaceship, sx, 0, null);
    }
}