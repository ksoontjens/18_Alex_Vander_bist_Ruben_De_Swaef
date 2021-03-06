package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;


public class HelloTVXlet implements Xlet, UserEventListener, HBackgroundImageListener, ResourceClient
{
    int NumberOfBalls = 1;
    private HScreen screen ;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundDevice bgDevice;
    private HBackgroundImage background=new HBackgroundImage("back3.m2v");
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        background.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        // Tijd = Subject
        Subject sub=new Subject();
  
        // Create scene + background
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        screen = HScreen.getDefaultHScreen ( ) ;
        bgDevice = screen.getDefaultHBackgroundDevice ( ) ;
        if(bgDevice.reserveDevice(this)){
            System.out.println("bgdevice has been reserved");
        }
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE,HBackgroundConfigTemplate.REQUIRED);
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        } catch (java.lang.Exception ex) {
            System.out.println(ex.toString());
        }
        
        // Add beams that observe the timer
        Beam beam1=new Beam("beamED.png", 100, 200, "left",sub);
        Beam beam2=new Beam("beamA.png", 600, 200, "right",sub);
        
        sub.register(beam1);
        sub.register(beam2);
        
        scene.add(beam1);
        scene.add(beam2);
        
        // Add balls that observe the timer
        for (int i=0;i<NumberOfBalls;i++)
        {
            Ball ball=new Ball(beam1, beam2);
            sub.register(ball);
            scene.add(ball);
        }
        
        // Show the scene
        scene.validate(); 
        scene.setVisible(true);
        
    }
    
    public void imageLoaded(HBackgroundImageEvent e){
        try {
            bgConfiguration.displayImage(background);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("backgroundimage cant be loaded");
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        background.load(this);
    }

    public void userEventReceived(UserEvent e) {
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}