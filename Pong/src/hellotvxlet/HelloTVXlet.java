package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet, UserEventListener
{
    int NumberOfBalls = 1;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        /*Observer ob1=new Observer();
        Observer ob2=new Observer();
        Observer ob3=new Observer();
        sub.register(ob1); sub.register(ob2); sub.register(ob3); */
        Subject sub=new Subject();
        
        MijnTimerTask mtt=new MijnTimerTask(sub);
        Timer tim=new Timer();
        tim.scheduleAtFixedRate(mtt, 0  , 10); // start op 0 elke 1000ms
  
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        for (int i=0;i<NumberOfBalls;i++)
        {
        Sprite ball=new Sprite("ball.png",100+30*i,100+30*i);
        sub.register(ball);
        scene.add(ball);
        }
        Beam beam1=new Beam("beam.png", 100, 100, "left");
        Beam beam2=new Beam("beam.png", 600, 100, "right");
        Beam background=new Beam("back.jpg", 0, 0, "center");
        sub.register(beam1);
        sub.register(beam2);
        scene.add(beam1);
        scene.add(beam2);
        scene.add(background);
        scene.validate(); scene.setVisible(true);
        
        
        
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }

    public void userEventReceived(UserEvent e) {
    }
    
    
}