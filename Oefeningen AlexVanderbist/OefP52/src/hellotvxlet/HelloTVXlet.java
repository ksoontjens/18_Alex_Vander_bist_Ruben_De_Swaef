package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
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


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener{
    
    HStillImageBackgroundConfiguration hsbic;
    HBackgroundImage image1,image2, image3, image4;
    int cursor =1;
    int imageTeller = 0;
    String lijst = "orderlijst: \n";
    HStaticText hst;

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        hst = new HStaticText(lijst,400,50,300,300);
        hst.setVerticalAlignment(hst.VALIGN_TOP);
        hst.setHorizontalAlignment(hst.HALIGN_LEFT);
        hst.setTextContent(lijst+"regel1\n", hst.NORMAL_STATE);
        
        scene.add(hst);
        scene.validate();
        scene.setVisible(true);
        
        HScreen screen = HScreen.getDefaultHScreen();
        HBackgroundDevice hbackgroundev = screen.getDefaultHBackgroundDevice(); 
        boolean gereserveerd = hbackgroundev.reserveDevice(this);
        if (gereserveerd) System.out.println("backgrounddev gereserveerd");
        
        //configuratie
        HBackgroundConfigTemplate hbct = new HBackgroundConfigTemplate();
        hbct.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hsbic = (HStillImageBackgroundConfiguration) hbackgroundev.getBestConfiguration(hbct);
        
        
        
        //image inladen
        image1=new HBackgroundImage("pizza1.m2v");
        image1.load(this); //bovenaan implement
        image2=new HBackgroundImage("pizza2.m2v");
        image2.load(this); //bovenaan implement
        image3=new HBackgroundImage("pizza3.m2v");
        image3.load(this); //bovenaan implement
        image4=new HBackgroundImage("pizza4.m2v");
        image4.load(this); //bovenaan implement
        
        //maak UserEventRepository
        UserEventRepository repo = new UserEventRepository("naam");
        //voeg daar allArrowKeys aan toe
        repo.addAllArrowKeys();
        repo.addKey(HRcEvent.VK_ENTER);
        //vraag een link naar EventManager op met .getInstance()
        EventManager eventMana = EventManager.getInstance();
        //registreer de UserRepo op de Eventman
        eventMana.addUserEventListener(this, repo);
        //implement de event manager op xlet

    }
    
    public void userEventReceived(UserEvent e) {
        //System.out.println(e.toString());
        if(e.getType() == KeyEvent.KEY_PRESSED) {
            
            if(e.getCode() == HRcEvent.VK_ENTER) {
                if(cursor == 1)lijst=lijst+"Meat Lovers \n";
                if(cursor == 2)lijst=lijst+"Pepperoni Lovers \n";
                if(cursor == 3)lijst=lijst+"Cheese Lovers \n";
                if(cursor == 4)lijst=lijst+"Vegi Lovers \n";
                hst.setTextContent(lijst, hst.NORMAL_STATE);
            }
                        
            switch(e.getCode()) {
                case HRcEvent.VK_LEFT: 
                    cursor++;
                    if(cursor > 4) cursor = 1;
                    break;
                case HRcEvent.VK_RIGHT:
                    cursor--;
                    if(cursor < 1) cursor = 4;
                    break;
            }
            try{
                System.out.println(cursor);
                if(imageTeller == 4 ) {
                    switch(cursor) {
                        case 1: hsbic.displayImage(image1); break;
                        case 2: hsbic.displayImage(image2);break;
                        case 3: hsbic.displayImage(image3);break;
                        case 4: hsbic.displayImage(image4);break;
                    }
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
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
        System.out.println("image geladen");
        
        try {
            hsbic.displayImage(image1);
            imageTeller++;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (HPermissionDeniedException ex) {
            ex.printStackTrace();
        } catch (HConfigurationException ex) {
            ex.printStackTrace();
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
