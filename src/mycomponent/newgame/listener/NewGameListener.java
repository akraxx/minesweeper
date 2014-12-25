/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.listener;

import mycomponent.newgame.event.PredefinedLevelEnableEvent;
import component.ComponentListener;
import mycomponent.customgame.event.PanelEnableChangedEvent;
import mycomponent.newgame.event.InitializationOccuredNewGameEvent;
import mycomponent.newgame.event.NewGameOccuredEvent;

/**
 *
 * @author group12
 */
public interface NewGameListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void predefinedLevelEnabled(PredefinedLevelEnableEvent e);
    
    /**
     *
     * @param e
     */
    public void initializationOccured(InitializationOccuredNewGameEvent e);
    
    /**
     *
     * @param e
     */
    public void panelVisibleChanged(PanelEnableChangedEvent e);
    
    
}
