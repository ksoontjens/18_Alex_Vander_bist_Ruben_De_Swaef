/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;

/**
 *
 * @author student
 */
public class Score extends HComponent implements ObserverInterface {
    public int score;
    HStaticText hst;
    
    public Score(int posx, int posy) {
        score = 0;

        
        
        hst = new HStaticText(Integer.toString(score),posx,posy,300,300);
        hst.setVerticalAlignment(HStaticText.VALIGN_TOP);
        hst.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        hst.setTextContent(Integer.toString(score), HStaticText.NORMAL_STATE);
        Font font = new Font("Courier New", Font.PLAIN, 50); 
        hst.setFont(font);
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        scene.add(hst);
        
    }

    public void update(int tijd) {
        // Tijd updated
        //System.out.println(score);
        hst.setTextContent(Integer.toString(score), HStaticText.NORMAL_STATE);
    }
    
    
}
