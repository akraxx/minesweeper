/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.customgame.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class PanelEnableChangedEvent extends ComponentEvent {
    private boolean enable;
    
    /**
     *
     * @param source
     * @param enable
     */
    public PanelEnableChangedEvent(Object source, boolean enable) {
        super(source);
        this.enable = enable;
    }

    /**
     *
     * @return
     */
    public boolean isEnable() {
        return enable;
    }

}
