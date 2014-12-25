/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.listener;

import component.ComponentListener;
import component.chronometer.event.ValueChangedChronometerEvent;

/**
 *
 * @author group12
 */
public interface ChronometerListener extends ComponentListener {
    
    /**
     *
     * @param e : event indicating that the chronometer's value(s) changed
     */
    public void valueChanged(ValueChangedChronometerEvent e);
    
}
