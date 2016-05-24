/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HIcon;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Beam extends HIcon implements ObserverInterface, UserEventListener {
    int x,y;
    String direction;
    Image img;
    int speed=5;
    public Beam(String bitmap_naam, int x, int y, String direction)
    {
        super();
        this.x=x; this.y=y;
        this.direction=direction;
        System.out.println(direction);
        img=this.getToolkit().getImage(bitmap_naam);
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(img,1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(img, HVisible.NORMAL_STATE);
        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
        
        UserEventRepository rep = new UserEventRepository("keys");
        rep.addAllArrowKeys();
        rep.addKey('Z');
        rep.addKey('S');
        EventManager man = EventManager.getInstance();
        man.addUserEventListener((UserEventListener) this,rep);
    }
    public void update(int tijd) {
        
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED){
            if(direction == "right"){
                switch (e.getCode() ){
                    case HRcEvent.VK_UP:
                        y-=speed;
                        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
                        this.repaint();
                        break;
                    case HRcEvent.VK_DOWN:
                        y+=speed;
                        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
                        this.repaint();
                        break;
                }
            }
            
            if(direction == "left"){
                switch (e.getCode() ){
                    case HRcEvent.VK_Z:
                        y-=speed;
                        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
                        this.repaint();
                        break;
                    case HRcEvent.VK_S:
                        y+=speed;
                        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
                        this.repaint();
                        break;
                }
            }
        }
    }

}
