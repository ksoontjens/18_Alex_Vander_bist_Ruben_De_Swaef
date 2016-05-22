package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    HStillImageBackgroundConfiguration hsbic;
    HBackgroundImage image1 = new HBackgroundImage("pizza1.m2v");
    HBackgroundImage image2 = new HBackgroundImage("pizza2.m2v");
    HBackgroundImage image3 = new HBackgroundImage("pizza3.m2v");
    HBackgroundImage image4 = new HBackgroundImage("pizza4.m2v");
    int imageteller = 0;
    int cursor = 1;
    String lijst = "Orderlijst";
    String pizza;
    HStaticText hst = new HStaticText(lijst, 400,50,300,300);

    
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScreen screen = HScreen.getDefaultHScreen();
        HBackgroundDevice hbackgrounddev = screen.getDefaultHBackgroundDevice();
        boolean reserved = hbackgrounddev.reserveDevice(this);
        if(reserved){
            System.out.println("backgrounddev reserved");
        }
        
        HBackgroundConfigTemplate hbct = new HBackgroundConfigTemplate();
        hbct.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hsbic=(HStillImageBackgroundConfiguration) hbackgrounddev.getBestConfiguration(hbct);
        
        
        
        image1.load(this);
        image2.load(this);
        image3.load(this);
        image4.load(this);
        
        
        
             
    }

    public void pauseXlet() {
      
    }

    public void startXlet() throws XletStateChangeException {
       UserEventRepository mijnrep = new UserEventRepository("naam");
        mijnrep.addAllArrowKeys();
        mijnrep.addKey(32);
        EventManager mijnManager = EventManager.getInstance();
        mijnManager.addUserEventListener(this,mijnrep);
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        hst.setVerticalAlignment(hst.VALIGN_TOP);
        hst.setHorizontalAlignment(hst.HALIGN_LEFT);
        hst.setTextContent(lijst, hst.NORMAL_STATE);
        scene.add(hst);
        scene.validate();
        scene.setVisible(true);
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

    public void imageLoaded(HBackgroundImageEvent e) {
        System.out.print("Image geladen");
        imageteller++;
        if(imageteller == 4) System.out.print("alles geladen");
        
        try {
            hsbic.displayImage(image1);
        } catch (IOException iOException) {
        } catch (HPermissionDeniedException hPermissionDeniedException) {
        } catch (HConfigurationException hConfigurationException) {
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.getCode());
        if(e.getType()== KeyEvent.KEY_PRESSED){
        if(e.getCode()== 37){
            //links
            
            if(cursor == 1){
                cursor = 4;
            }
            else {
                cursor--;
            }
        }
        else if(e.getCode()== 39){
            //rechts
           if(cursor == 4){
                cursor = 1;
            }
            else {
                cursor++;
            }
            
        }
        
            try {
                if (imageteller == 4) {
                    if (cursor == 1) {
                        hsbic.displayImage(image1);
                        pizza = "pizza 1";
                    }
                    if (cursor == 2) {
                        hsbic.displayImage(image2);
                        pizza = "pizza 2";
                    }
                    if (cursor == 3) {
                        hsbic.displayImage(image3);
                        pizza = "pizza 3";
                    }
                    if (cursor == 4) {
                        hsbic.displayImage(image4);
                        pizza = "pizza 4";
                    }
                }
            } catch (IOException iOException) {
            } catch (HPermissionDeniedException hPermissionDeniedException) {
            } catch (HConfigurationException hConfigurationException) {
            }
        
        if(e.getCode()==32){
            lijst += "\n" + pizza;
            hst.setTextContent(lijst, hst.NORMAL_STATE);
        }
        }
    }

    
}
