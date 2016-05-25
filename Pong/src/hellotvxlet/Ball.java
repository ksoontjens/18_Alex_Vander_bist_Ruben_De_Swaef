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
public class Ball extends HIcon implements ObserverInterface, UserEventListener {
    String ballImgFile = "ball.png";
    Image ballImg;
    int speed = 3;
    float vertSpeed = 0f;
    Beam beam1;
    Beam beam2;
    int x,y;
    boolean applyVerticalSpeed;

    // Constructor
    public Ball (Beam beam1, Beam beam2) {
        super();
        
        this.beam1 = beam1;
        this.beam2 = beam2;
        
        // Load ball image
        ballImg = this.getToolkit().getImage(ballImgFile);
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(ballImg,1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.x = 300;
        this.y = 300;
        this.setGraphicContent(ballImg, HVisible.NORMAL_STATE);
        this.setBounds(this.x, this.y, ballImg.getWidth(this), ballImg.getHeight(this));
    }
    
    public void update(int tijd) {
        
        
        this.setBounds(x, y, ballImg.getWidth(this), ballImg.getHeight(this));
        
        // check if colliding with a beam
        Beam collider = null;
        if(getCollision(beam1) >= 0) collider = beam1;
        else if(getCollision(beam2) >= 0) collider = beam2;
        
        if(collider instanceof Beam) {
            // we collided with a beam
            
            // switch directions
            speed=-speed; 
                        
            float collisionHeight = getCollision(collider);
            float collisionPercentage = (collisionHeight / collider.img.getHeight(collider));
            System.out.println("We collided with " + collider.direction + " at " + collisionPercentage + "%");
            
            // check if we need to make a corner
            if(collisionPercentage > 0f && collisionPercentage < 0.3f){
                System.out.println("Changing corner");
                vertSpeed -= 1f;
            }
            if(collisionPercentage < 1f && collisionPercentage > 0.7f) {
                System.out.println("Changing corner");
                vertSpeed += 1f;
            }
        }
               
        x+=speed; // move the ball hor
        y+=vertSpeed; // move the ball vertically
        if(applyVerticalSpeed) y+=vertSpeed;
        else applyVerticalSpeed = true;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private float getCollision(Beam beam) {
        float state = -1f;
        if((beam.direction == "left" && x < beam.x + beam.img.getWidth(beam)) ||
           (beam.direction == "right" && (x + this.ballImg.getWidth(this)) > beam.x)) {
           
            // horizontal hit, now check for vert
            if(y > beam.y && y < beam.y + beam.img.getHeight(beam)) {
                state = y - beam.y;
            }
        }
        return state;
    }

    public void userEventReceived(UserEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}