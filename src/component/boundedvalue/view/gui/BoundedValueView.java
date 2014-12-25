/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.view.gui;

import component.ComponentView;
import component.boundedvalue.event.InitializationOccuredEvent;
import component.boundedvalue.event.LabelChangedEvent;
import component.boundedvalue.item.view.gui.SliderBoundedValueItemView;
import component.boundedvalue.item.view.gui.TextFieldBoundedValueItemView;
import component.boundedvalue.listener.BoundedValueListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author group12
 */
public class BoundedValueView extends JPanel implements ComponentView, BoundedValueListener {
    
    private SliderBoundedValueItemView sliderView;
    private TextFieldBoundedValueItemView textFieldView;
    private JLabel label;
    
    private void initComponent(String label) {
        this.label = new JLabel(label);
        
        this.add(this.textFieldView, BorderLayout.EAST);
        this.add(this.sliderView, BorderLayout.CENTER);
        this.add(this.label, BorderLayout.WEST);
        
    }
    
    /**
     *
     * @param slider : allows to create a custom bounded slider
     * @param textField : text to be displayed on-screen
     */
    public BoundedValueView(SliderBoundedValueItemView slider, TextFieldBoundedValueItemView textField) {
        super(new BorderLayout());
        if(slider != null && textField != null) {
            this.sliderView = slider;
            this.textFieldView = textField;
        }
        else {
            throw new NullPointerException("Slider or TextField view can not be null");
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void labelChanged(LabelChangedEvent e) {
        this.label.setText(e.getLabel());
    }

    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitializationOccuredEvent e) {
        this.initComponent(e.getLabel());
    }
}
