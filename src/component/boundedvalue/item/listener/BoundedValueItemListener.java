/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.listener;

import component.boundedvalue.item.event.BoundsChangedEvent;
import component.boundedvalue.item.event.InitilializationOccuredEvent;
import component.boundedvalue.item.event.ValueChangedEvent;

/**
 *
 * @author group12
 */
public interface BoundedValueItemListener {
    
    /**
     *
     * @param e event containing the previous and next values 
     */
    public void valueChanged(ValueChangedEvent e);
    
    /**
     *
     * @param e event containing the previous and next minimum and maximum
     */
    public void boundsChanged(BoundsChangedEvent e);
    
    /**
     *
     * @param e event notifying a component has been created and initialized (values set)
     */
    public void initializationOccured(InitilializationOccuredEvent e);
    
}
