/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.event;

import component.boundedvalue.item.model.BoundedValueItemModel;
import component.event.ComponentEvent;

/**
 *
 * @author group12
 */
public class InitializationOccuredEvent extends ComponentEvent {
    private String label;
    private BoundedValueItemModel itemModel;
    
    /**
     *
     * @param source
     * @param itemModel
     * @param label
     */
    public InitializationOccuredEvent(Object source, BoundedValueItemModel itemModel, String label) {
        super(source);
        if(itemModel != null) {
            this.itemModel = itemModel;
            this.label = label;
        }
        else {
            throw new NullPointerException("BoundedValueItemModel can not be null");
        }
    }

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @return
     */
    public BoundedValueItemModel getItemModel() {
        return itemModel;
    }
    
}
