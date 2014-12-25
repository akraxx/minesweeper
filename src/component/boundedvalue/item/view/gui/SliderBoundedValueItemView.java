/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.boundedvalue.item.view.gui;

import component.boundedvalue.item.event.BoundsChangedEvent;
import component.boundedvalue.item.event.InitilializationOccuredEvent;
import component.boundedvalue.item.event.ValueChangedEvent;
import component.boundedvalue.item.listener.BoundedValueItemListener;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author group12
 */
public class SliderBoundedValueItemView extends JSlider implements BoundedValueItemListener {
    /**
     *  allows to define the behaviour of a custom slider: 
     *  the orientation, the paint labels and paint ticks
     */
    public static final boolean DEFAULT_PAINTTICKS = true;
    /**
     *
     */
    public static final boolean DEFAULT_PAINTLABELS = true;
    /**
     *
     */
    public static final int DEFAULT_MINORTICKS = 5;
    /**
     *
     */
    public static final int DEFAULT_MAJORTICKS = 5;
    
    private void changeBounds(int minimum, int maximum) {
        this.setMaximum(maximum);
        this.setMinimum(minimum);
        
        this.setMajorTickSpacing((maximum - minimum) / DEFAULT_MAJORTICKS);
        this.setMinorTickSpacing(this.getMajorTickSpacing() / DEFAULT_MINORTICKS);
    }
    
    private void changeValue(int value) {
        this.setValue(value);
    }
    
    /**
     *
     * @param paintTicks : whether to display the paint ticks
     * @param paintLabels : whether to display the paint labels
     * @param orientation : the orienation of a slider
     */
    public SliderBoundedValueItemView(boolean paintTicks, boolean paintLabels, int orientation) {
        this.setPaintTicks(paintTicks);
        this.setPaintLabels(paintLabels);
        this.setOrientation(orientation);
    }
    
    /**
     *
     * @param paintTicks : whether to display the paint ticks
     * @param paintLabels : whether to display the paint labels
     */
    public SliderBoundedValueItemView(boolean paintTicks, boolean paintLabels) {
        this(paintTicks, paintLabels, SwingConstants.HORIZONTAL);
    }
    
    /**
     *
     */
    public SliderBoundedValueItemView() {
        this(DEFAULT_PAINTTICKS, DEFAULT_PAINTLABELS);
    }

    /**
     *
     * @param e : an event notifying a slider's value changed
     */
    @Override
    public void valueChanged(ValueChangedEvent e) {
        this.changeValue(e.getNewValue());
    }

    /**
     *
     * @param e : an event notifying a slider's bounds changed
     */
    @Override
    public void boundsChanged(BoundsChangedEvent e) {
        this.changeBounds(e.getNewMinimum(), e.getNewMaximum());
    }
    
    /**
     *
     * @param e : an event notifying a slider has been created and its value initialized
     */
    @Override
    public void initializationOccured(InitilializationOccuredEvent e) {
        this.changeValue(e.getDefaultValue());
        this.changeBounds(e.getMinimum(), e.getMaximum());
    }
    
}
