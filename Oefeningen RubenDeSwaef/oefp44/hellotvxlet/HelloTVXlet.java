package hellotvxlet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.*;


public class HelloTVXlet implements Xlet, UserEventListener {

  
    public HelloTVXlet() {
        
    }
    public MijnComponent mc = new MijnComponent(0,0,720,576);
    int x;
    int y;
    public void initXlet(XletContext context) {
       HScene scene = HSceneFactory.getInstance().getDefaultHScene();
       scene.add(mc);
       
       
       
       scene.validate();
       scene.setVisible(true);
       
     
    }

    public void startXlet() {
    UserEventRepository mijnrep = new UserEventRepository("naam");
    mijnrep.addAllArrowKeys();
    EventManager mijnManager = EventManager.getInstance();
    mijnManager.addUserEventListener(this,mijnrep);
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.getCode());
        if(e.getCode() == 37){
        x = x - 5;
        }
        else if(e.getCode() == 39){
        x = x +5;
        }
        else if(e.getCode() == 40){
        y = y + 5;
        }
        else if(e.getCode() == 38){
        y = y - 5;
        }
        
        if(x >= 720-45){
            x = 720-45;
        }
        else if(x<=0){
            x = 0;
        }
        if(y >= 576-48){
            y = 576-48;
        }
        else if(y<=0){
            y = 0;
        }
        
        mc.setSchipPos(x, y);
    }
    
    
}
