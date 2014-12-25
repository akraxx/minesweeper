/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component.chronometer.view;

import component.chronometer.event.ValueChangedChronometerEvent;
import component.chronometer.listener.ChronometerListener;
import javax.swing.JLabel;

/**
 *
 * @author group12
 */
public class LabelChronometerView extends JLabel implements ChronometerListener {

    /**
     *
     * @param e : event indicating the chronometer's values changed
     */
    @Override
    public void valueChanged(ValueChangedChronometerEvent e) {
        this.setText((e.getHours() +":"+ e.getMinutes() + ":" + e.getSeconds() + ":" + e.getCentseconds()));
    }
    
}
