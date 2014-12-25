/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.listener;

import component.ComponentListener;
import mycomponent.levelchooser.event.CustomLevelSelectedEvent;
import mycomponent.levelchooser.event.LevelChoosedEvent;
import mycomponent.levelchooser.event.PredefinedLevelSelectedEvent;

/**
 *
 * @author group12
 */
public interface LevelSelectedListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void predefinedLevelSelected(PredefinedLevelSelectedEvent e);
    
    /**
     *
     * @param e
     */
    public void customLevelSelected(CustomLevelSelectedEvent e);
}
