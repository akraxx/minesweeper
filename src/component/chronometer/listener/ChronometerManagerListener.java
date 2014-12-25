/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.listener;

import component.ComponentListener;

/**
 *
 * @author group12
 */
public interface ChronometerManagerListener extends ComponentListener{
    
    /**
     * starts a custom chronometer
     */
    public void startOccured();
    
    /**
     * stops the actually running chronometer
     */
    public void stopOccured(); 
}
