/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class BoundsChangedEvent extends ComponentEvent {
    private int newMinimum;
    private int newMaximum;

    /**
     *
     * @param source component whose bounds changed
     * @param newMinimum : new minimum bound
     * @param newMaximum : new maximum bound
     */
    public BoundsChangedEvent(Object source, int newMinimum, int newMaximum) {
        super(source);
        this.newMinimum = newMinimum;
        this.newMaximum = newMaximum;
    }

    /**
     *
     * @return
     */
    public int getNewMinimum() {
        return newMinimum;
    }

    /**
     *
     * @return
     */
    public int getNewMaximum() {
        return newMaximum;
    }
    
}
