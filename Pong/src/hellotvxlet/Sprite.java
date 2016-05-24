/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HIcon;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Sprite extends HIcon implements ObserverInterface {
    int x,y;
    Image img;
    int speed=5;
    public Sprite(String bitmap_naam, int x, int y)
    {
        super();
        this.x=x; this.y=y;
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
    }
    public void update(int tijd) {
        x+=speed; if (x>600 || x < 100) speed=-speed;
        this.setBounds(x, y, img.getWidth(this), img.getHeight(this));
        this.repaint();
    }

}
