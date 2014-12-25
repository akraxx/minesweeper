/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.model;

import component.boundedvalue.item.event.BoundsChangedEvent;
import component.boundedvalue.item.event.InitilializationOccuredEvent;
import component.boundedvalue.item.event.ValueChangedEvent;
import component.boundedvalue.item.listener.BoundedValueItemListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author group12
 */
public class BoundedValueItemModel {
    private List<BoundedValueItemListener> listeners = new LinkedList<>();
    private int minimum;
    private int maximum;
    
    private int defaultValue;
    private int value;
    
    /**
     * fires an event which notifies an item's value changed
     */
    private void fireValueChangedEvent() {
        for(BoundedValueItemListener l : this.listeners) {
            l.valueChanged(new ValueChangedEvent(this, this.value));
        }
    }
    
    /**
     * fires an event which notifies an item's bound values changed
     */
    private void fireBoundsChangedEvent() {
        for(BoundedValueItemListener l : this.listeners) {
            l.boundsChanged(new BoundsChangedEvent(this, this.minimum, this.maximum));
        }
    }
    
    /**
     * fires an event which notifies an item has been created and its values initialized
     */
    private void fireInitializationOccuredEvent() {
        for(BoundedValueItemListener l : this.listeners) {
            l.initializationOccured(new InitilializationOccuredEvent(this, this.defaultValue, this.minimum, this.maximum));
        }
    }
    
    /**
     *
     * @param minimum : the minimum bound
     * @param maximum : the maximum bound
     * @param defaultValue : the default value
     * @param value = defaultValue for now
     */
    public BoundedValueItemModel(int minimum, int maximum, int defaultValue, int value) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.defaultValue = defaultValue;
        this.value = value;
        this.fireInitializationOccuredEvent();
    }
    
    /**
     *
     * @param minimum : the minimum bound
     * @param maximum : the maximum bound
     * @param defaultValue : the default value
     */
    public BoundedValueItemModel(int minimum, int maximum, int defaultValue) {
        this(minimum, maximum, defaultValue, defaultValue);
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
     * @param minimum
     */
    public void setMinimum(int minimum) {
        this.minimum = minimum;
        this.fireBoundsChangedEvent();
    }

    /**
     *
     * @return
     */
    public int getMaximum() {
        return maximum;
    }

    /**
     *
     * @param maximum
     */
    public void setMaximum(int maximum) {
        this.maximum = maximum;
        this.fireBoundsChangedEvent();
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
     * @param defaultValue
     */
    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        if(value > this.maximum) {
            this.value = this.maximum;
        }
        else if(value < this.minimum) {
            this.value = this.minimum;
        }
        else {
            this.value = value;
        }
        
        this.fireValueChangedEvent();
    }
    
    /**
     *
     * @param l : itemListener to add
     */
    public void addListener(BoundedValueItemListener l) {
        if(l != null) {
            this.listeners.add(l);
            l.initializationOccured(new InitilializationOccuredEvent(this, this.defaultValue, this.minimum, this.maximum));
        }
        else {
            throw new NullPointerException("Bounded Value Listener can not be null");
        }
    }
}
