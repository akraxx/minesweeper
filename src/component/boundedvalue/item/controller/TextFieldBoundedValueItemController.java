/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.controller;

import component.boundedvalue.item.model.BoundedValueItemModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author group12
 */
public class TextFieldBoundedValueItemController implements ActionListener {
    
    BoundedValueItemModel model;

    /**
     *
     * @param model the text field's model to control
     */
    public TextFieldBoundedValueItemController(BoundedValueItemModel model) {
        if(model != null) {
            this.model = model;
        }
        else {
            throw new NullPointerException("BoundedValueModel can not be Null");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JTextField) {
            JTextField f = (JTextField)e.getSource();
            try {
                this.model.setValue(Integer.valueOf(f.getText()));
            }
            catch (NumberFormatException ex) {
                this.model.setValue(this.model.getDefaultValue());
            }
        }
    }
}
