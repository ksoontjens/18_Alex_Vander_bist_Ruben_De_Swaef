/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
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
    int applyVerticalSpeed;
    int[] Score;
    
    float maxCorner = 4f;
    
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
        this.setBordersEnabled(false);
        
        Score = new int[2];
    }   

    public void setBordersEnabled(boolean enable) {
        super.setBordersEnabled(enable);
    }
    
    public void update(int tijd) {
        
        
        this.setBounds(x, y, ballImg.getWidth(this), ballImg.getHeight(this));
        
        // check if colliding with a beam
        Beam collider = null;
        if(getCollision(beam1) >= 0) collider = beam1;
        else if(getCollision(beam2) >= 0) collider = beam2;
        
        if(collider instanceof Beam) 
        {
            // we collided with a beam
            
            // switch directions
            speed=-speed; 
                        
            float collisionHeight = getCollision(collider);
            float collisionPercentage = (collisionHeight / collider.img.getHeight(collider));
            System.out.println("We collided with " + collider.direction + " at " + collisionPercentage + "%");
            
            // check if we need to make a corner
            if(collisionPercentage > 0f && collisionPercentage < 0.2f){
                if(vertSpeed > -maxCorner)vertSpeed -= 2f;
            }
            if(collisionPercentage < 1f && collisionPercentage > 0.8f) {
                if(vertSpeed < maxCorner)vertSpeed += 2f;
                
            }
            if(collisionPercentage > 0.2f && collisionPercentage < 0.4f){
                if(vertSpeed > -maxCorner)vertSpeed -= 1f;
            }
            if(collisionPercentage < 0.8f && collisionPercentage > 0.6f) {
                if(vertSpeed < maxCorner)vertSpeed += 1f;
                
            }
        }
        
        // Check if colliding with ceiling or floor
        if(y < 10) {
            vertSpeed = java.lang.Math.abs(vertSpeed);
        }
        else if(y > 560) {
            vertSpeed = - java.lang.Math.abs(vertSpeed);
        }
        
        //SCORE
        if(x<0 | x>700) {
            if(x<0){
                this.Score[1]++;
            }
            if(x>700){
                this.Score[0]++;
            }
            this.x = 300;
            this.y = 300;
            this.speed = 3;
            this.vertSpeed = 0f;
        }
               
        x+=speed; // move the ball hor
        if(applyVerticalSpeed < 5)  {
            y+=vertSpeed; applyVerticalSpeed++;
        } else applyVerticalSpeed = 0;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private float getCollision(Beam beam) {
        float state = -1f;
        if((beam.direction == "left" && x < beam.x + beam.img.getWidth(beam) && (x + this.ballImg.getWidth(this)) > beam.x) ||
           (beam.direction == "right" && (x + this.ballImg.getWidth(this)) > beam.x) && x < beam.x + beam.img.getWidth(beam)) {
           
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
