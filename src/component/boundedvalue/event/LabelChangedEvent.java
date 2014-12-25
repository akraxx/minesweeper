/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.event;

import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class LabelChangedEvent extends ComponentEvent {
    private String label;
    
    /**
     *
     * @param source
     * @param label
     */
    public LabelChangedEvent(Object source, String label) {
        super(source);
        this.label = label;
    }

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }

}
