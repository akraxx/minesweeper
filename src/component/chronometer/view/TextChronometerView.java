/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.view;

import component.chronometer.event.ValueChangedChronometerEvent;
import component.chronometer.listener.ChronometerListener;

/**
 *
 * @author group12
 */
public class TextChronometerView implements ChronometerListener {

    /**
     *
     * @param e : event indicating the chronometer's values changed
     * and need to be displayed again
     */
    @Override
    public void valueChanged(ValueChangedChronometerEvent e) {
        System.out.println(e.getHours() +":"+ e.getMinutes() + ":" + e.getSeconds() + ":" + e.getCentseconds());
    }
    
}
