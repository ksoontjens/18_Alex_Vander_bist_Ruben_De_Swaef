package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet
{
    int NumberOfBalls = 1;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        Observer ob1=new Observer();
        Observer ob2=new Observer();
        Observer ob3=new Observer();
        Subject sub=new Subject();
        sub.register(ob1); sub.register(ob2); sub.register(ob3);
        
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
        Sprite beam1=new Sprite("beam.png", 100, 100);
        Sprite beam2=new Sprite("beam.png", 600, 100);
        scene.add(beam1);
        scene.add(beam2);
        scene.validate(); scene.setVisible(true);
        
        
        
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }
    
    
}