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
public class InitilializationOccuredEvent extends ComponentEvent {
    private int defaultValue;
    
    private int minimum;
    private int maximum;

    /**
     *
     * @param source : the component initialized
     * @param defaultValue : the default value of the component
     * @param minimum : the component's minimum
     * @param maximum : the component's maximum
     */
    public InitilializationOccuredEvent(Object source, int defaultValue, int minimum, int maximum) {
        super(source);
        this.defaultValue = defaultValue;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     *
     * @return
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    /**
     *
     * @return
     */
    public int getMinimum() {
        return minimum;
    }

    /**
     *
     * @return
     */
    public int getMaximum() {
        return maximum;
    }
    
}
