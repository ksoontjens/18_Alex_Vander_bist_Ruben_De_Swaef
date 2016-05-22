
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    Image spaceship;
    private MediaTracker mtrack;
    public int schipx = 0;
    public int schipy = 0;
    public MijnComponent(int x, int y, int w, int h){
        this.setBounds(x,y,w,h);
        spaceship = this.getToolkit().getImage("spaceship.png");
        mtrack=new MediaTracker(this);
        mtrack.addImage(spaceship,0);
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(100,100,100,179));
        g.fillRect(0,0,100,100);
        g.setColor(Color.white);
        g.drawString("Tekst1",15,20);
        g.drawImage(spaceship,schipx,schipy,null);
    }
    
    public void setSchipPos(int x, int y){
        
        schipx = x;
        schipy = y;
        this.repaint();
    }
    
    
}
