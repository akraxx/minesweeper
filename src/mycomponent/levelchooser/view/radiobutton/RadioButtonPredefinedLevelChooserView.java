/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponent.levelchooser.view.radiobutton;

import javax.swing.JLabel;
import mycomponent.levelchooser.event.InitializationOccuredLevelChooserEvent;

/**
 *
 * @author group12
 */
public class RadioButtonPredefinedLevelChooserView extends RadioButtonLevelChooserView {

    /**
     *
     */
    public RadioButtonPredefinedLevelChooserView() {
        this.add(this.button);
    }
    
    
    private String createLabel(String label, int rows, int columns, int mines) {
        return label + ": " + mines + " mines in a " + rows + " x " + columns + " field"; 
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void initializationOccured(InitializationOccuredLevelChooserEvent e) {
        this.button.setText(this.createLabel(e.getLabel(), e.getRows(), e.getColumns(), e.getMines()));
    }
    
}
