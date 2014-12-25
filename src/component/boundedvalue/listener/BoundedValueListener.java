/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.listener;

import component.ComponentListener;
import component.boundedvalue.event.InitializationOccuredEvent;
import component.boundedvalue.event.LabelChangedEvent;

/**
 *
 * @author group12
 */
public interface BoundedValueListener extends ComponentListener {
    
    /**
     *
     * @param e : an event notifying an item's label has been changed
     */
    public void labelChanged(LabelChangedEvent e);
    
    /**
     *
     * @param e : an event notifying an item has been created and initialized
     */
    public void initializationOccured(InitializationOccuredEvent e);
}
