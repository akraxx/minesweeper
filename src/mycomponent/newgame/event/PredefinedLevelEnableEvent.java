/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.newgame.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class PredefinedLevelEnableEvent extends ComponentEvent {
    private boolean enable;

    /**
     *
     * @param source
     * @param enabled
     */
    public PredefinedLevelEnableEvent(Object source, boolean enabled) {
        super(source);
        this.enable = enabled;
    }

    /**
     *
     * @return
     */
    public boolean isEnable() {
        return enable;
    }
}
