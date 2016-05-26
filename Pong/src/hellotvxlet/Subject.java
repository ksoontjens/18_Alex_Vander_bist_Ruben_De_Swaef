/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import java.util.Timer;

/**
 *
 * @author student
 */
public class Subject implements SubjectInterface {

    ArrayList subscribers=new ArrayList();
    
    public Subject () {
        // Subject laat observers iedere x ms weten welke tijd het is. (hammertime)
        MijnTimerTask mtt=new MijnTimerTask(this);
        Timer tim=new Timer();
        tim.scheduleAtFixedRate(mtt, 0  , 10); // start op 0 elke 1000ms
    }
    
    public void register(ObserverInterface ob) {
        subscribers.add(ob);
    }

    public void unregister(ObserverInterface ob) {
        subscribers.remove(ob);
    }
    
    public void update_observers(int tijd)
    {
        for (int i=0;i<subscribers.size();i++)
        {
        ((ObserverInterface)subscribers.get(i)).update(tijd);
        }
    }

}
