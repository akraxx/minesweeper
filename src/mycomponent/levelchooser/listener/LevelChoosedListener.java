/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.listener;

import component.ComponentListener;
import mycomponent.levelchooser.event.LevelChoosedEvent;

/**
 *
 * @author group12
 */
public interface LevelChoosedListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void levelSelected(LevelChoosedEvent e);
    
}
