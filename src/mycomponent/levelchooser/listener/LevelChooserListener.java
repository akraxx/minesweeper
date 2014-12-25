/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.listener;

import component.ComponentListener;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;

/**
 *
 * @author group12
 */
public interface LevelChooserListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void initializationOccured(InitializationOccuredLevelChooserEvent e);
    
}
