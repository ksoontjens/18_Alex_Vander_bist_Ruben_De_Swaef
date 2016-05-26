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
    public int x,y;
    public String direction;
    public Image img;
    int speed=3;
    int[] keysPressed;
    int beamHeight=100;
    public Score score;
    public Beam(String bitmap_naam, int x, int y, String direction, Subject sub)
    {
        super();
        
        this.x=x; this.y=y;
        this.direction=direction;
        keysPressed = new int[4];
        //System.out.println(direction);
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
        this.setBordersEnabled(false);
        
        UserEventRepository rep = new UserEventRepository("keys");
        rep.addAllArrowKeys();
        rep.addKey('E');
        rep.addKey('D');
        EventManager man = EventManager.getInstance();
        man.addUserEventListener((UserEventListener) this,rep);
        
        
        // New Score text
        score = new Score(x,40);
        sub.register(score);
    }
    public void update(int tijd) {
        //System.out.println(keysPressed[1]);
        if(keysPressed[0] == 1 | keysPressed[2] == 1)
        {
            y-=speed;
            //System.out.println("rightUp");
            this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
            this.repaint();
        }
        else if(keysPressed[1] == 1 | keysPressed[3] == 1)
        {
            y+=speed;
            this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
            this.repaint();   
        }
        
        if(y < 35) {
            y=35;
            this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
            this.repaint(); 
        }
        else if(y > 525-beamHeight) {
            y=525-beamHeight;
            this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
            this.repaint(); 
        }
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED){
            if(direction == "right"){
                switch (e.getCode() ){
                    case HRcEvent.VK_UP:
                        keysPressed[0] = 1;
                        break;
                    case HRcEvent.VK_DOWN:
                        keysPressed[1] = 1;
                        break;
                }
            }
            
            if(direction == "left"){
                switch (e.getCode() ){
                    case HRcEvent.VK_E:
                        keysPressed[2] = 1;
                        break;
                    case HRcEvent.VK_D:
                        keysPressed[3] = 1;
                        break;
                }
            }
        }
        
        if(e.getType() == KeyEvent.KEY_RELEASED){
            if(direction == "right"){
                switch (e.getCode() ){
                    case HRcEvent.VK_UP:
                        keysPressed[0] = 0;
                        break;
                    case HRcEvent.VK_DOWN:
                        keysPressed[1] = 0;
                        break;
                }
            }
            
            if(direction == "left"){
                switch (e.getCode() ){
                    case HRcEvent.VK_E:
                        keysPressed[2] = 0;
                        break;
                    case HRcEvent.VK_D:
                        keysPressed[3] = 0;
                        break;
                }
            }
        }
    }

}
