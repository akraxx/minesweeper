/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.view.gui;

import component.boundedvalue.item.event.BoundsChangedEvent;
import component.boundedvalue.item.event.InitilializationOccuredEvent;
import component.boundedvalue.item.event.ValueChangedEvent;
import component.boundedvalue.item.listener.BoundedValueItemListener;
import javax.swing.JTextField;

/**
 *
 * @author group12
 */
public class TextFieldBoundedValueItemView extends JTextField implements BoundedValueItemListener {
    
    private void changeValue(int value) {
        this.setText(String.valueOf(value));
    }
    
    private void changeBounds(int maximum) {
        this.setColumns(String.valueOf(maximum).length());
    }
    
    /**
     *
     */
    public TextFieldBoundedValueItemView() {

    }

    
    /**
     *
     * @param e : an event notifying a text field's value changed
     */
    @Override
    public void valueChanged(ValueChangedEvent e) {
        this.changeValue(e.getNewValue());
    }

    /**
     *
     * @param e : an event notifying a text field's bounds changed
     */
    @Override
    public void boundsChanged(BoundsChangedEvent e) {
        this.changeBounds(e.getNewMaximum());
    }

    /**
     *
     * @param e : an event notifying a text field has been created and its value initialized
     */
    @Override
    public void initializationOccured(InitilializationOccuredEvent e) {
        this.changeValue(e.getDefaultValue());
        this.changeBounds(e.getMaximum());
    }

    
}
