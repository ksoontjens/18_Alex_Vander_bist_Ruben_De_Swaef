package hellotvxlet;

import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, UserEventListener {
    
    int sx = 0;
    MijnComponent mc;

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent(10,450,500,100);
        //MijnComponent mc2 = new MijnComponent(250,400,100,100);
        
        scene.add(mc);
        //scene.add(mc2);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        UserEventRepository mijnRep = new UserEventRepository("naam");
        mijnRep.addAllArrowKeys();
        EventManager mijnMan = EventManager.getInstance();
        mijnMan.addUserEventListener(this, mijnRep);
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.toString());
        if(e.getCode() == HRcEvent.VK_LEFT) {
            sx+=3;
            mc.setSpaceship(sx);
        }
        if(e.getCode() == HRcEvent.VK_RIGHT) {
            sx-=3;
            mc.setSpaceship(sx);
        }
    }
    
    
}