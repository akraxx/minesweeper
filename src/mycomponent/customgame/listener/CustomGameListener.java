/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.customgame.listener;

import component.ComponentListener;
import mycomponent.customgame.event.PanelEnableChangedEvent;

/**
 *
 * @author group12
 */
public interface CustomGameListener extends ComponentListener {
    
    /**
     *
     * @param e
     */
    public void panelEnableChanged(PanelEnableChangedEvent e);
    
}
