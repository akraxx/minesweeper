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
public class ValueChangedEvent extends ComponentEvent {
    private int newValue;

    /**
     *
     * @param source : the component whose value changed
     * @param newValue : the new value to set
     */
    public ValueChangedEvent(Object source, int newValue) {
        super(source);
        this.newValue = newValue;
    }

    /**
     *
     * @return
     */
    public int getNewValue() {
        return newValue;
    }
    
}
