/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.controller;

import component.boundedvalue.item.model.BoundedValueItemModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author group12
 */
public class SliderBoundedValueItemController implements ChangeListener {
    
    BoundedValueItemModel model;

    /**
     *
     * @param model the item's model to control 
     */
    public SliderBoundedValueItemController(BoundedValueItemModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("BoundedValueModel can not be Null");
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSlider) {
            JSlider source = (JSlider)e.getSource();
            
            if (!source.getValueIsAdjusting()) {
                this.model.setValue((int)source.getValue());
            }
        }
    }
    
}
